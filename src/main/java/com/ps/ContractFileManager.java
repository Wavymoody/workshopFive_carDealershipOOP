package com.ps;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {

    public static Contract saveContract(Contract contract) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true));

            if (contract instanceof SalesContract) {
                String contractType = "Sale";

                String isFinacedYesNo;
                if (((SalesContract) contract).isFinanced()) {
                    isFinacedYesNo = "Yes";
                } else {
                    isFinacedYesNo = "No";
                }


                String contractLine = String.format(
                        "%s|%s|%s|%s|%d|%d|\n\n\t%s|%s|%s|%s|%d|%.2f|\n\n\t%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                        contractType,
                        contract.getDate(),
                        contract.getCustomerName(),
                        contract.getEmail(),
                        contract.getVehicleSold().getVin(),
                        contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(),
                        contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getType(),
                        contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(),
                        ((SalesContract) contract).getSalesTaxAmount(),
                        ((SalesContract) contract).getRecordingFee(),
                        ((SalesContract) contract).getProcessingFee(),
                        contract.getTotalPrice(),
                        isFinacedYesNo,
                        contract.getMonthlyPayment()
                );

                bufferedWriter.write(contractLine);
                bufferedWriter.newLine();
                bufferedWriter.close();

            } else if (contract instanceof LeaseContract) {

                String contractType = "Lease";

                String contractLine = String.format(
                        "%s|%s|%s|%s|%d|%d|\n\n\t%s|%s|%s|%s|%d|%.2f|\n\n\t%.2f|%.2f|%.2f|%.2f",

                        contractType,
                        contract.getDate(),
                        contract.getCustomerName(),
                        contract.getEmail(),
                        contract.getVehicleSold().getVin(),
                        contract.getVehicleSold().getYear(),

                        contract.getVehicleSold().getMake(),
                        contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getType(),
                        contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(),

                        ((LeaseContract) contract).getExpectedEndingValue(),
                        ((LeaseContract) contract).getLeaseFee(),
                        contract.getTotalPrice(),
                        contract.getMonthlyPayment()
                );


                bufferedWriter.write(contractLine);
                bufferedWriter.newLine();
                bufferedWriter.close();

            } else {
                System.out.println("Try Again");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return contract;
    }
}