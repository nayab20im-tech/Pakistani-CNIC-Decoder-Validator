# Pakistani CNIC Decoder & Validator

## Overview
[cite_start]This Java-based application is a command-line utility designed to validate and analyze Pakistani Computerized National Identity Card (CNIC) numbers[cite: 367]. [cite_start]It accepts a 13-digit CNIC string and the year of issuance, parses the structural components of the ID, and extracts demographic and administrative details such as the cardholder's province, division, and gender[cite: 371]. [cite_start]It also automatically calculates the card's expiration date[cite: 372].

## Features
* [cite_start]**Input Validation:** Ensures the provided CNIC consists of exactly 13 digits (excluding dashes)[cite: 369].
* [cite_start]**Province Identification:** Extracts the first digit of the CNIC to determine the cardholder's province or territory[cite: 395, 410].
* [cite_start]**Division Analysis:** Analyzes the division code (second digit) to identify specific administrative regions (e.g., Gujranwala Division)[cite: 385, 428].
* [cite_start]**Gender Decoding:** Determines the gender of the cardholder based on the last digit of the CNIC (Odd for Male, Even for Female)[cite: 378, 379].
* [cite_start]**Expiry Calculation:** Automatically calculates the card's expiry year based on a standard 10-year validity period from the issue year[cite: 384].

## Logic & Mappings

### Province Codes (First Digit)
[cite_start]The application maps the first digit of the CNIC to the following territories [cite: 415-427]:
* `1`: Khyber Pakhtunkhwa
* `2`: FATA (Federally Administered Tribal Areas)
* `3`: Punjab
* `4`: Sindh
* `5`: Balochistan
* `6`: Islamabad Territory
* `7`: Gilgit-Baltistan

### Gender Codes (Last Digit)
* **Odd Numbers (1, 3, 5, 7, 9):** Male
* [cite_start]**Even Numbers (0, 2, 4, 6, 8):** Female [cite: 436]

### Division Codes
The system specifically checks the division code (second digit). [cite_start]If the digit is `4`, it is identified as **Gujranwala**; otherwise, it is flagged as not belonging to that specific division[cite: 385].

## Usage

### Prerequisites
* Java Development Kit (JDK) installed.
* A terminal or command prompt.

### Execution
1.  Compile the Java file:
    ```bash
    javac CNICInfo.java
    ```
2.  Run the application:
    ```bash
    java CNICInfo
    ```
3.  Follow the on-screen prompts to enter the CNIC (without dashes) and the Issue Year.

## Example Output

**Scenario 1: Valid Input**
```text
Enter your CNIC number (without dashes):
3410156984558
Enter the year of Card Issue (e.g. 2022):
2020

******** THE CARDHOLDER DETAILS **************
Province: Punjab
Division: Gujranwala
Gender: Female
Expiry Year: 2030

**Scenario 2: Valid Input**
Enter your CNIC number (without dashes):
6106595584102
Enter the year of Card Issue (e.g. 2022):
2021

*** THE CARDHOLDER DETAILS ****
Province: Islamabad Territory
Division: NOT BELONGS TO GUJRANWALA
Gender: Female
Expiry Year: 2031

Scenario 3: Invalid Input
Enter your CNIC number (without dashes):
341016565594563
Please enter a valid CNIC number.

Project Structure
The core logic is contained within the CNICInfo class, utilizing the following helper methods:


isValidCNIC(String cnic): Validates length.


analyzeCNIC(String cnic, int issueYear): Main driver for data extraction.


determineProvince(int provinceCode): Maps codes to region names.


determineDivision(int divisionCode): Extracts division identifier.


determineGender(int genderCode): Decodes gender status.


calculateExpiryYear(int issueYear): Computes validity period.

License
This project is open-source and available under the MIT License.
