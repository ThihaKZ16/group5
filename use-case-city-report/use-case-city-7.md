#USE CASE: 7 The top N populated cities in a continent where 10 is provided by the user.
##CHARACTERISTIC INFORMATION
###Goal in Context

As an *Executive Director* I want *to produce a report on top N populated cities in a continent by user * so that *I can support financial reporting of the organisation.*
###Scope

Organization.
###Level

Primary task.
###Preconditions

We know the role. Database contains current cities data.
###Success End Condition

A report is available for Executive Director to print to cities data.
###Failed End Condition

No report is produced.
###Primary Actor

Executive Director.
###Trigger

A request for finance information is sent to Population Management System.
###MAIN SUCCESS SCENARIO

1. Finance request population information by cities.
2. Executive Director captures name of the role to get population information by cities.
3. Executive Director extracts current population information by cities.
4. Executive Director provides report to finance.

##EXTENSIONS
None.


##SUB-VARIATIONS

None.
##SCHEDULE

**DUE DATE**: March25, 2022. Release 0.1.0-alpha2