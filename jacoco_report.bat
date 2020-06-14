call mvn test
call mvn jacoco:report
set reportpath="%~dp0target\site\jacoco\index.html"
call start firefox %reportpath%