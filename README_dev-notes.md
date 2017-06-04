
Assumptions:
* Commas are delimiters.
* There must be the same number of open and close parentheses.
* The double quotes on the example input string can be ignored, not actually part of the problem.
* Solution needs to be able to handle any number of legal/matching parentheses.
* The space between "```(id),``` and  ```lastname``` in the example input string is not a typo, showing that spaces can be ignored.
* ```()```, ```id)id```, ```((``` and ```))``` are not legal
* Closing parentheses are followed by comma, ex: ```),```, with the exception of the last one.
* Nothing is allowed to follow the close parenthesis, which matches the first open parenthesis.  Ex: ```(employee(name1, name2),id),job(job1,job2),id)```
* The solution will also work on other "legal" strings.  Ex: ```(employee(name1, name2),id,job(job1,job2),id)```

Idea for how to solve
* Perform all error checking on the string, as listed in the assumptions above.
* Remove all spaces.
* Next tokenize the input, using comma as the delimiter.  The result being

```(id created employee(id firstname employeeType(id) lastname) location)```

* Sudo code - first attempt
```
repeat 

    if token contains paren
        if open paren, or if more then one then the first one is open
                indent_count ++
                // (only on the first one) if token starts with open paren, drop it and store the token&count
                else token contains open paren - recurse on this token?
        else close paren, or first one seen is close
                indent_count--
                if token ends with close paren, drop it and store token&count
                // this is not legal, else token contains close paren - now what?
    else token contains no parens
        store token&count

until count == 0
```
* Sudo code - second attempt
```
do all error checking
create tokens from string, with comma for delimiter, and removing any spaces
indent-level = 0
loop on tokens
    if token has no parens
        save token
    else
        if token has left paren
            if paren is at the begining
                indent-level ++
                remove paren
                save token and indent-level
            else paren must be impeded
                // Example "employee(id"
                // tokenize on first left paren
                // save token "empployee" and indent-level
                // recursion?
        else token must have right paren, at end of the token
            indent-level --
            remove paren
            save token and indent-level
end loop
```
What would it look like if I broken it up on the parens?  I would need to be able to figure out what the matching parens were.
```
(id created employee(id firstname employeeType(id) lastname) location)
(id firstname employeeType(id) lastname)
(id)
```

* sudo code - third attempt

Recusion like this maybe?
```
call find-matching-paren (full-list-of-tokens, false, 0)

find-matching-paren (tokens, found-left-paren, indent-level)
    loop on tokens
        if token starts with left paren
            remaining-tokens = drop left paren
            find-matching-paren (remaining-tokens, true, indent-level ++)
        else if token contains left paren
            print/store chars before left paren, and indent-level
            remaining-tokens = drop left paren, chars before it
            find-matching-paren (remaining-tokens, true, indent-level )
        else if token ends with right paren
            print/store chars before right paren, and indent-level
            exit
    end loop
```

Guide to the code

* ParsingExample.java - my first attempt
* ParseExample.java - my second and third attempts


* Wasn't successful at solving the problem