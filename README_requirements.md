Parameters
1. Should be solved in a language which demonstrates your skill for the position you have applied.
2. Deliver a working runnable solution and include a copy of the source code.
3. Write code typical of something we would be proud to have in Frontline software in production.
4. You will need to independently overcome any challenges you face in delivery.
5. If applicable, please list your assumptions.

Problem to Solve

Convert the string:
```
"(id,created,employee(id,firstname,employeeType(id), lastname),location)"
```
to the following output
```
id
created
employee
- id
- firstname
- employeeType
-- id
- lastname
location
```
Bonus (output in alphabetical order):
```
created
employee
- employeeType
-- id
- firstname
- id
- lastname
id
location
```
