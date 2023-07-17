# Oracle TNSPING
*JDBC Oracle ping utility*

usage: 
* **-h**           *Help*.
* **-nsn <arg>**   *Tnsping connect to remote database using OCI driver and
service name stored on tnsname.ora*
* **-nss <arg>**   *Tnsping connect to remote database with string.*

example :
> * java -jar tnsping-executable.jar -nss net_service_string
> * java -jar tnsping-executable.jar -nsn net_service_name

where:
> * net_service_name : must exist in tnsnames.ora file.
> * net_service_string : a valid connect string  to be used by Oracle JDBC driver.
>   * (DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=[HOST])(PORT=[PORT]))(CONNECT_DATA=(SERVICE_NAME=[SERVICE_NAME])(SERVER=DEDICATED)))
