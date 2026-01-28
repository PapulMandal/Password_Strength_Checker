import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PASSWORD STRENGTH CHECKER ===");
        System.out.println("Enter a password to check its strength:");
        System.out.println("(Type 'exit' to quit)");

        while (true) {
            System.out.print("\nEnter password: ");
            String password = scanner.nextLine();

            if (password.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            checkPasswordStrength(password);

            System.out.print("\nWould you like password suggestions? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                generateStrongPassword();
            }
        }

        scanner.close();
    }

    public static void checkPasswordStrength(String password) {
        System.out.println("\n=== ANALYZING PASSWORD ===");
        System.out.println("Password: " + maskPassword(password));
        System.out.println("Length: " + password.length() + " characters");

        // Check individual criteria
        boolean hasUppercase = hasUppercase(password);
        boolean hasLowercase = hasLowercase(password);
        boolean hasDigits = hasDigits(password);
        boolean hasSpecialChars = hasSpecialChars(password);
        boolean hasNoSpaces = !password.contains(" ");
        boolean hasMinLength = password.length() >= 8;
        boolean hasGoodLength = password.length() >= 12;
        boolean hasExcellentLength = password.length() >= 16;

        // Display criteria check
        System.out.println("\n--- CRITERIA CHECK ---");
        System.out.println("Contains uppercase letters: " + (hasUppercase ? "YES" : "NO"));
        System.out.println("Contains lowercase letters: " + (hasLowercase ? "YES" : "NO"));
        System.out.println("Contains digits: " + (hasDigits ? "YES" : "NO"));
        System.out.println("Contains special characters: " + (hasSpecialChars ? "YES" : "NO"));
        System.out.println("No spaces: " + (hasNoSpaces ? "YES" : "NO"));
        System.out.println("Minimum length (8+): " + (hasMinLength ? "YES" : "NO"));

        // Calculate score
        int score = 0;
        if (hasUppercase) score += 1;
        if (hasLowercase) score += 1;
        if (hasDigits) score += 1;
        if (hasSpecialChars) score += 1;
        if (hasNoSpaces) score += 1;
        if (hasMinLength) score += 1;
        if (hasGoodLength) score += 1;
        if (hasExcellentLength) score += 1;

        // Determine strength level
        String strength;
        String recommendation;

        if (score >= 7) {
            strength = "VERY STRONG";
            recommendation = "Excellent password! Consider using a password manager to store it securely.";
        } else if (score >= 5) {
            strength = "STRONG";
            recommendation = "Good password. Could be stronger by adding more length or special characters.";
        } else if (score >= 3) {
            strength = "MODERATE";
            recommendation = "Fair password. Consider adding uppercase letters, digits, or special characters.";
        } else if (score >= 1) {
            strength = "WEAK";
            recommendation = "Poor password. Should be longer and include more character types.";
        } else {
            strength = "VERY WEAK";
            recommendation = "Extremely weak. Consider using a completely different password.";
        }

        // Display results
        System.out.println("\n--- STRENGTH ASSESSMENT ---");
        System.out.println("Score: " + score + "/8");
        System.out.println("Strength: " + strength);
        System.out.println("\nRecommendation: " + recommendation);

        // Show character analysis
        System.out.println("\n--- CHARACTER ANALYSIS ---");
        analyzeCharacters(password);

        // Show common patterns
        checkCommonPatterns(password);
    }

    // Helper methods using String operations
    private static boolean hasUppercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigits(String password) {
        // Using contains with regex
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialChars(String password) {
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?/`~";
        for (int i = 0; i < password.length(); i++) {
            if (specialChars.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static void analyzeCharacters(String password) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int digitCount = 0;
        int specialCount = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                specialCount++;
            }
        }

        System.out.println("Uppercase letters: " + uppercaseCount);
        System.out.println("Lowercase letters: " + lowercaseCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Special characters: " + specialCount);

        // Show character distribution (FIXED: using isEmpty() instead of length() > 0)
        if (!password.isEmpty()) {
            System.out.println("\nCharacter distribution:");
            System.out.println("First character: '" + password.charAt(0) + "'");
            System.out.println("Last character: '" + password.charAt(password.length() - 1) + "'");

            if (password.length() >= 3) {
                System.out.println("Middle character(s): '" +
                        password.substring(password.length()/2 - 1, password.length()/2 + 1) + "'");
            }
        }
    }

    private static void checkCommonPatterns(String password) {
        System.out.println("\n--- PATTERN CHECK ---");

        // Check for sequences
        boolean hasSequence = false;
        for (int i = 0; i < password.length() - 2; i++) {
            String substring = password.substring(i, i + 3);
            if (isConsecutiveSequence(substring)) {
                System.out.println("Contains sequence: " + substring);
                hasSequence = true;
            }
        }

        // Check for repeated characters
        boolean hasRepeats = false;
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) &&
                    password.charAt(i) == password.charAt(i + 2)) {
                System.out.println("Contains repeated characters: '" + password.charAt(i) + "'");
                hasRepeats = true;
                break;
            }
        }

        // Check common weak passwords (FIXED: "letmein" is correct, not a typo)
        String[] weakPasswords = {
                "password", "123456", "qwerty", "admin", "welcome",
                "password123", "letmein", "monkey", "dragon"  // "letmein" is intentionally one word
        };

        for (String weak : weakPasswords) {
            if (password.toLowerCase().contains(weak.toLowerCase())) {
                System.out.println("Contains common weak pattern: " + weak);
                break;
            }
        }

        if (!hasSequence && !hasRepeats) {
            System.out.println("No obvious patterns detected");
        }
    }

    private static boolean isConsecutiveSequence(String str) {
        // Check if string contains consecutive characters (abc, 123, etc.)
        if (str.length() < 3) return false;

        // Check ascending
        boolean ascending = true;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1) + 1) {
                ascending = false;
                break;
            }
        }

        // Check descending
        boolean descending = true;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1) - 1) {
                descending = false;
                break;
            }
        }

        return ascending || descending;
    }

    private static String maskPassword(String password) {
        int length = password.length();

        // For very short passwords (4 characters or less), mask everything
        if (length <= 4) {
            return "*".repeat(length);
        }

        // For longer passwords, show first 2 and last 2 characters
        String firstTwo = password.substring(0, 2);
        String lastTwo = password.substring(length - 2);
        String maskedMiddle = "*".repeat(length - 4);

        return firstTwo + maskedMiddle + lastTwo;
    }
    // Password generator (now being used)
    public static void generateStrongPassword() {
        System.out.println("\n=== STRONG PASSWORD SUGGESTIONS ===");

        String[] suggestions = {
                generateRandomPassword(12),
                generateRandomPassword(14),
                generateRandomPassword(16)
        };

        for (int i = 0; i < suggestions.length; i++) {
            System.out.println((i + 1) + ". " + suggestions[i]);
        }

        System.out.println("\nTip: Use a unique password for each account!");
    }

    private static String generateRandomPassword(int length) {
        // FIXED: Correct character sets without typos
        String uppercase = "ABCDEFGHJKLMNPQRSTUVWXYZ";  // Removed duplicate N, missing M
        String lowercase = "abcdefghijkmnpqrstuvwxyz";  // Removed 'o', kept correct
        String digits = "23456789";  // Excludes 0 and 1
        String special = "!@#$%^&*";

        String allChars = uppercase + lowercase + digits + special;
        StringBuilder password = new StringBuilder();

        // Ensure at least one of each type
        password.append(getRandomChar(uppercase));
        password.append(getRandomChar(lowercase));
        password.append(getRandomChar(digits));
        password.append(getRandomChar(special));

        // Fill the rest randomly
        for (int i = 4; i < length; i++) {
            password.append(getRandomChar(allChars));
        }

        // Shuffle the password
        return shuffleString(password.toString());
    }

    private static char getRandomChar(String chars) {
        int index = (int) (Math.random() * chars.length());
        return chars.charAt(index);
    }

    private static String shuffleString(String input) {
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}