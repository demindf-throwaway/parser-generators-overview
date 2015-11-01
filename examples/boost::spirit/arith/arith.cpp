#include <boost/spirit/include/qi.hpp>
#include <boost/spirit/include/phoenix_core.hpp>
#include <boost/spirit/include/phoenix_operator.hpp>
#include <boost/spirit/include/phoenix_object.hpp>

#include <iostream>
#include <string>

#include <cmath>

namespace qi = boost::spirit::qi;
namespace phoenix = boost::phoenix;
namespace ascii = boost::spirit::ascii;

BOOST_PHOENIX_ADAPT_FUNCTION(double, pow, std::pow, 2)

template<typename Iterator>
struct arith_grammar
    : qi::grammar<Iterator, double(), ascii::space_type>
{
    arith_grammar()
        : arith_grammar::base_type(expr , "expr")
    {
        using qi::double_;
        using qi::_val;
        using namespace qi::labels;
        using qi::on_error;
        using qi::fail;
        using phoenix::construct;
        using phoenix::val;
        using qi::debug;
        expr %= sum;
        sum = prod                  [_val = _1 ]
           >> *('+' >> prod         [_val += _1]
               |'-' >> prod         [_val -= _1]
               )
            ;
        prod = exp                  [_val = _1       ]
            >>  *('*' >> exp        [_val = _val * _1]
                 |'/' >> exp        [_val = _val / _1]
                 )
             ;
        exp = value                 [_val = _1         ]
           >> -('^' >> exp          [_val = pow(_val, _1)])
            ;
        value %= double_ | '(' >> expr >> ')';

        expr.name("expr");
        sum.name("sum");
        prod.name("prod");
        exp.name("exp");
        value.name("value");
        on_error<fail>
            (
                expr
              , std::cout
                    << val("Error! Expecting ")
                    << _4                               // what failed?
                    << val(" here: \"")
                    << construct<std::string>(_3, _2)   // iterators to error-pos, end
                    << val("\"")
                    << std::endl
            );
        // debug(expr);
        // debug(sum);
        // debug(prod);
        // debug(expr);
        // debug(value);
    }

    typedef qi::rule<Iterator, double(), ascii::space_type> rule_t;
    rule_t expr;
    rule_t sum;
    rule_t prod;
    rule_t exp;
    rule_t value;
};

std::string input(std::istream& in)
{
    char const* prompt = "=> ";
    std::cout << prompt;
    std::string answer;
    std::getline(std::cin, answer);
    return answer;
}

void repl(std::istream& in, std::ostream& out)
{
    arith_grammar<std::string::const_iterator> arith;

    while (true)
    {
        using boost::spirit::ascii::space;
        auto request = input(in);
        if (request == "exit") break;
        
        double result;
        auto iter = request.cbegin();
        auto end = request.cend();
        bool r = qi::phrase_parse(iter, end, arith, space, result);                
        if (r && iter == end)
        {
            out << result << std::endl;
        }
        else
        {
            out << "Parse error" << std::endl;
        }
    }    
}

int main(int argc, char** argv)
{
    repl(std::cin, std::cout);
}
