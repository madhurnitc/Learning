package org.learn.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] splittedEmail = email.split("@");
            String local = splittedEmail[0];
            String domain = splittedEmail[1];
            int index = local.indexOf("+");
            if (index >= 0) {
                local = local.substring(0, index);
            }
            local = local.replaceAll("\\.", "");

            uniqueEmails.add(local + domain);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        new UniqueEmailAddress().numUniqueEmails(new String[]{"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"});
    }
}
