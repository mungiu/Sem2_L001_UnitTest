package b;

import java.io.*;

public class FileIO {

    private String filePath;

    public FileIO() {
        filePath = "users";
    }

    public void addUser(String userName, String password) {
        try {
            Writer out = new BufferedWriter(new FileWriter(filePath, true));
            out.append(userName).append("##").append(password).append(System.getProperty("line.separator"));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String validateUser(String userName, String password) {
        if(!(new File(filePath)).exists()) {
            return "User doesn't exist";
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = in.readLine()) != null) {
                String[] data = line.split("##");
                if(userName.equalsIgnoreCase(data[0].trim())) {
                    if(password.trim().equalsIgnoreCase(data[1].trim())) {
                        return "OK";
                    } else {
                        return "Incorrect password";
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "User doesn't exist";
    }

    public String changePassword(String userName, String oldPassword, String newPassword) {
        File inputFile = null;
        File tempFile = null;
        String result = "OK";
        try {
            inputFile = new File(filePath);
            tempFile = new File("myTempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean changed = false;
            while((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split("##");

                if(data[0].trim().equals(userName)) {
                    if(data[1].trim().equals(oldPassword)) {
                        currentLine = userName + "##" + newPassword;
                        writer.write(currentLine + System.getProperty("line.separator"));
                        changed = true;
                    } else {
                        writer.write(currentLine + System.getProperty("line.separator"));
                        result = "Incorrect password";
                        changed = true;
                    }
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.flush();
            writer.close();
            reader.close();
            if(!changed) {
                result = "User not found";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        inputFile.delete();

        boolean successful = tempFile.renameTo(inputFile);


        return successful ? result : "Error, try again";
    }

    public boolean userExists(String userName) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = in.readLine()) != null) {
                String[] data = line.split("##");
                if(userName.equals(data[0].trim())) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
