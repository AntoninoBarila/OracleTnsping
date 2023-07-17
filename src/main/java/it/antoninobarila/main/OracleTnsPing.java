package it.antoninobarila.main;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import it.antoninobarila.db.DBConnect;
import it.antoninobarila.db.DBConnectionInfo;
import it.antoninobarila.enumeration.DBConnectionTypeEnum;

import java.io.IOException;

public class OracleTnsPing {

    public static void main(String[] args) {

        CommandLine cmd = null;
        try {
            cmd = validateCliOption(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (cmd.hasOption("nsn")) {
            DBConnectionInfo.setDbStrConnect(cmd.getOptionValue("nsn"));
            DBConnectionInfo.setDbConnType(DBConnectionTypeEnum.OCI);
        } else {
            DBConnectionInfo.setDbStrConnect(cmd.getOptionValue("nss"));
            DBConnectionInfo.setDbConnType(DBConnectionTypeEnum.THIN);
        }

        DBConnect connTest = new DBConnect();

        connTest.connectDB();

        System.exit(0);
    }

    private static void usage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Tnsping", options);
        System.out.println("\nexample :");
        System.out.println("1) java -jar tnsping-executable.jar -nss net_service_string");
        System.out.println("2) java -jar tnsping-executable.jar -nsn net_service_name ");
        System.out.println("\nWhere:");
        System.out.println("* net_service_name : must exist in tnsnames.ora file.");
        System.out.println("* net_service_string : a valid connect string to be used by Oracle JDBC driver.");
    }

    private static CommandLine validateCliOption(String[] args) throws IOException {
        System.out.println(new ApplicationDetails().info() + "\n");

        // create Options object
        Options options = new Options();

        // add command line options to be parsed.
        options.addOption("h", false, "print this help.");
        options.addOption("nss", true, "Tnsping connect to remote database with string .");
        options.addOption("nsn", true, "Tnsping connect to remote database using OCI driver and service name stored on tnsname.ora");

        if (args.length < 1) {
            System.out.println("Not enough parameters...");
            usage(options);
            System.exit(1);
        }

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            usage(options);
            throw new RuntimeException(e.getMessage());
        }

        if (cmd.hasOption("h")) {
            usage(options);
            System.exit(0);
        }

        return cmd;
    }

}
