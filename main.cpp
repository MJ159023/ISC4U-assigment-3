/*
 * Copyright (c) 2025 St. Mother Teresa HS All rights reserved.
 * The program runs Sylvesters numbers.
 *
 * @author  Michael Bruneau
 * @version 1.0
 * @since   2020-11-30
 */

// setup
#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::cin;

/**
 * This function generates sylvester's numbers.
 * It takes number sylvester nummber needed using previous input from user
 * It then uses sylvester formula to calcualte the next number
 * It then prints out the out the previous calculating before recusrsing
 *
 * @param runTimes
 * @param sylvesterNumber
 * @return function again
 */
int sylvesterNumberGenerator(int runTimes, int sylvesterNumber) {
    // variables
    int nextSylvesterNumber = sylvesterNumber;

    if (runTimes == 0) {
        cout << sylvesterNumber << ".";
        return sylvesterNumber;
    } else {
        nextSylvesterNumber = nextSylvesterNumber * nextSylvesterNumber
                - nextSylvesterNumber + 1;
        cout << sylvesterNumber << ",";
        return sylvesterNumberGenerator(runTimes - 1, nextSylvesterNumber);
    }
}

/**
 * Runs main.
 *
 * @param args
 */
int main() {
    // variables
    string numberOfSylvesterNumbers;
    bool loop = true;
    // constants
    /**
     * holds sylvester number a(0).
     */
    const int SYLVESTER_NUMBER_ZERO = 2;

    while (loop) {
        // gets input
        cout << "Input number of sylvester numbers you want"
                        << " outputed after a(0): ";
        cin >> numberOfSylvesterNumbers;

        // makes sure input is valid
        try {
             // tries to convert input to integer
             int loopTimes = std::stoi(numberOfSylvesterNumbers);

             // checks if number selected is above or equal to zero
             if (loopTimes >= 0) {
                // sets loop to false if input is valid and uses method
                loop = false;
                sylvesterNumberGenerator(loopTimes, SYLVESTER_NUMBER_ZERO);
             } else {
                // error message
                cout << "\nInvalid input. Number must be equal "
                                    << "to or larger than zero.";
             }

        } catch (const std::invalid_argument &err) {
             // error message
             cout << "\nInvalid input.";
        }
    }
}


