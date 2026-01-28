# Password_Strength_Checker
A comprehensive Java application that analyzes password security and provides detailed strength assessment with actionable recommendations.

## Features
### Password Analysis
- **Length Validation**: Checks for minimum (8+), good (12+), and excellent (16+) lengths
- **Character Variety**: Verifies presence of uppercase, lowercase, digits, and special characters
- **Pattern Detection**: Identifies sequences, repeated characters, and common weak patterns
- **Spaces Check**: Ensures passwords don't contain spaces

### Strength Assessment
- **Scoring System**: 8-point scale based on security criteria
- **Strength Levels**: Very Weak → Weak → Moderate → Strong → Very Strong
- **Detailed Reports**: Character distribution and pattern analysis
- **Personalized Recommendations**: Specific suggestions for improvement

### Security Features
- **Weak Password Detection**: Checks against common vulnerable passwords
- **Pattern Warnings**: Alerts for sequences like "123" or "abc"
- **Password Masking**: Securely displays passwords with hidden characters
- **Strong Password Generator**: Creates secure password suggestions

## Getting Started

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Installation
1. Clone or download the project files
2. Open in your preferred Java IDE
3. Compile and run `PasswordStrengthChecker.java`

### Usage
1. Run the program
2. Enter a password to analyze
3. Review the detailed strength assessment
4. Optionally generate strong password suggestions
5. Type 'exit' to quit

## Password Scoring Criteria

| Criteria | Points |
|----------|--------|
| Contains uppercase letters | +1 |
| Contains lowercase letters | +1 |
| Contains digits (0-9) | +1 |
| Contains special characters | +1 |
| No spaces | +1 |
| Minimum length (8+ characters) | +1 |
| Good length (12+ characters) | +1 |
| Excellent length (16+ characters) | +1 |

**Total Possible Score: 8 points**

### Strength Levels
- **7-8 points**: VERY STRONG
- **5-6 points**: STRONG
- **3-4 points**: MODERATE
- **1-2 points**: WEAK
- **0 points**: VERY WEAK

## Technical Implementation

### String Operations Used
- `length()` - Checks password length
- `contains()` - Searches for patterns and characters
- `substring()` - Extracts portions for analysis
- `charAt()` - Character-by-character examination
- `isEmpty()` - Validates non-empty input
- `toLowerCase()` - Case-insensitive comparisons

### Key Methods
- `checkPasswordStrength()` - Main analysis function
- `analyzeCharacters()` - Character distribution analysis
- `checkCommonPatterns()` - Pattern detection
- `generateStrongPassword()` - Secure password generation
- `maskPassword()` - Safe password display

## Example Output

=== ANALYZING PASSWORD ===
Password: He*****3!
Length: 9 characters

--- CRITERIA CHECK ---
✓ Contains uppercase letters: YES
✓ Contains lowercase letters: YES
✓ Contains digits: YES
✓ Contains special characters: YES
✓ No spaces: YES
✓ Minimum length (8+): YES

--- STRENGTH ASSESSMENT ---
Score: 6/8
Strength: STRONG

--- CHARACTER ANALYSIS ---
Uppercase letters: 1
Lowercase letters: 4
Digits: 3
Special characters: 1

Character distribution:
First character: 'H'
Last character: '!'

--- PATTERN CHECK ---
✓ No obvious patterns detected


## Best Practices Recommended

### Do's
- ✅ Use 12+ characters minimum
- ✅ Mix uppercase, lowercase, digits, and special characters
- ✅ Use unique passwords for different accounts
- ✅ Consider using a password manager
- ✅ Change passwords periodically

### Don'ts
- ❌ Don't use personal information (names, birthdays)
- ❌ Don't use dictionary words
- ❌ Don't use simple sequences (123, abc, qwerty)
- ❌ Don't reuse passwords across sites
- ❌ Don't store passwords in plain text

## Password Generator

The built-in generator creates passwords that:
- Exclude ambiguous characters (l, I, O, 0, 1)
- Include at least one of each character type
- Are randomly shuffled for maximum security
- Come in 12, 14, and 16-character variants

## Learning Objectives

This project demonstrates:
1. String manipulation and analysis in Java
2. Conditional logic and scoring systems
3. User input handling and validation
4. Security best practices
5. Clean code principles and refactoring

## Common Issues & Solutions

| Issue | Solution |
|-------|----------|
| "Method is never used" | Call `generateStrongPassword()` or remove unused code |
| "Condition covered by subsequent condition" | Remove redundant checks (e.g., `isEmpty()` when checking length) |
| "Typo in word" | Verify spelling or add to dictionary |
| Input validation errors | Ensure proper scanner handling |

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit changes with descriptive messages
4. Push to the branch
5. Open a pull request

## License
This project is open source and available for educational and personal use.
