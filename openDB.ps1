Write-Output jdbc:hsqldb:hsql://localhost/aimtrainerBDD
Set-Location C:\Users\Panda\Documents\hsqldb\lib
java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:aimtrainerdb --dbname.0 aimtrainerBDD
