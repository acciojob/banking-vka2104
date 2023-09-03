package com.driver;

import javax.naming.TimeLimitExceededException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        try {
            if(balance < this.getMinBalance()) {
                throw new Exception("Insufficient Balance");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
    }

    private boolean isValidLicenseId(String suffledLicenseId) {
        String[] licenseArr = suffledLicenseId.split("");
        String previousValue = "";
        for(String ch: licenseArr) {
            if(ch.equals(previousValue)) return false;
            previousValue = ch;
        }
        return true;
    }
    private void makeValidLicenseId() throws Exception{
        try {
            String[] licenseArr = this.tradeLicenseId.split("");
            StringBuilder res = new StringBuilder();
            List<String> arr = new ArrayList<String>(Arrays.asList(licenseArr));
            for(int i = 0; i < arr.size() - 1; i++) {
                if(arr.get(i).equals(arr.get(i+1))) {
                    arr.add(arr.get(i+1));
                    arr.remove(i+1);
                    i--;
                } else {
                    res.append(arr.get(i));
                }
            }
            res.append(arr.get(arr.size() - 1));
            if(isValidLicenseId(res.toString())) {
                this.tradeLicenseId = res.toString();
            } else {
                throw new Exception("Valid License can not be generated");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void validateLicenseId() throws Exception {
        boolean isValid = this.isValidLicenseId(this.tradeLicenseId);
        if(!isValid) {
            makeValidLicenseId();
        }
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

    }


}
