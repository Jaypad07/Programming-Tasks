package com.codegym.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Reading and writing to a file: CodeGym

*/

public class Solution {
    public static void main(String[] args) {
        // You can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        try {
            File yourFile = File.createTempFile("C:\\Users\\jaypa\\Documents\\CodeGymTasks\\CodeGymTasks\\2.JavaCore\\src\\com\\codegym\\task\\task20\\task2002\\Test.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            CodeGym codeGym = new CodeGym();
            // Initialize users field for the codeGym object here
            User user = new User();
            user.setFirstName("Carl");
            user.setLastName("Benzer");
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setCountry(User.Country.UNITED_STATES);
            codeGym.users.add(user);


            codeGym.save(outputStream);
            outputStream.flush();

            CodeGym loadedObject = new CodeGym();
            loadedObject.load(inputStream);
            // Here check that the codeGym object is equal to the loadedObject object

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class CodeGym {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            // Implement this method
            PrintWriter writer = new PrintWriter(outputStream);
            
            String isUserListEmpty = users.size() == 0 ? "yes" : "no";
            writer.println(isUserListEmpty);

            if (isUserListEmpty.equals("no")) {
                for (User x : users) {
                    writer.println(x.getFirstName());
                    writer.println(x.getLastName());
                    writer.println(x.isMale());
                    writer.println(x.getBirthDate());
                    writer.println(x.getCountry().getDisplayName());
                }
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUserListEmpty = reader.readLine();
            if (isUserListEmpty.equals("no")) {
                //int count = Integer.parseInt(reader.readLine());
                while (reader.ready()) {
                    User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        String isMale = reader.readLine();
                        user.setMale(isMale.equals("true"));
                        user.setBirthDate(new Date(reader.readLine()));
                        String country = reader.readLine();
                        if (country.equals(User.Country.UNITED_STATES.getDisplayName())) {
                            user.setCountry(User.Country.UNITED_STATES);
                        }else if (country.equals(User.Country.UNITED_KINGDOM.getDisplayName())) {
                            user.setCountry(User.Country.UNITED_KINGDOM);
                        } else if (country.equals(User.Country.OTHER.getDisplayName())) {
                            user.setCountry(User.Country.OTHER);
                        }
                        users.add(user);
                }
                reader.close();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CodeGym codeGym = (CodeGym) o;

            return users != null ? users.equals(codeGym.users) : codeGym.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
