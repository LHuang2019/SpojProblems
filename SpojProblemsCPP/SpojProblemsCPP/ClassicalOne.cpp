#include "stdafx.h"
#include "ClassicalOne.h"
#include <string>
#include <iostream>

using namespace std;

/*
Solved classical -> AP - Complete The Series (Easy), ID 11063
*/
void ClassicalOne::completeTheSeriesEasy()
{
	int numInput;
	scanf_s("%d", &numInput);

	long long int f, l, sum, n, d, i;

	while (numInput-- > 0)
	{
		scanf_s("%lld%lld%lld", &f, &l, &sum);
		
		n = 2 * sum / (f + l);
		d = (l - f) / (n - 5);
		i = f - 3 * d;

		printf("%lld\n", n);

		while (n-- > 0)
			printf("%lld ", i += d);
			
		printf("\n");
	}
}

/*
Solved classical -> Onotole needs your help, ID 7742
reference: https://medium.com/@Sirvan3TR/c-xor-solution-to-an-odd-occurrence-681c04e0295
*/
void ClassicalOne::onotoleNeedsYourHelp()
{
	int numInput, current;
	int result = 0;

	scanf("%d", &numInput);

	while (numInput--)
	{
		scanf("%d", &current);
		result = result ^ current;
	}

	printf("%d", result);
}

void ClassicalOne::theNextPalindrome()
{
	int numInput;
	string input, left, right, leftR, output;
	long leftRInt;
	scanf("%d", &numInput);

	while (numInput--)
	{
		cin >> input;
		if (input.length() < 2)
		{
			printf("%d", stoi(input) == 9 ? 11 : stoi(input) + 1);
			continue;
		}

		while (true)
		{
			left = leftR = input.substr(0, input.length() / 2);
			reverse(leftR.begin(), leftR.end());
			right = input.substr(input.length() / 2 + input.length() % 2, input.length());

			leftRInt = stol(leftR);
			if (leftRInt > stol(right))
			{
				if (leftRInt == 1)
				{
					output = input.substr(0, input.length() - 1);
					output += "1";
				}
				else
				{
					output = input.substr(0, input.length() / 2 + input.length() % 2);
					output += leftR;
				}
				cout << output << "\n";
				break;
			}

			output = to_string(stol(input.substr(0, input.length() / 2 + input.length() % 2)) + 1);
			input = output + right.replace(0, right.length(), "0");
		}
	}
}

/*
Solved classical -> Sum Of Digits, ID 29154
*/
void ClassicalOne::sumOfDigits()
{
	int numInput;
	string current;

	scanf("%d", &numInput);
	
	while (numInput--)
	{
		cin >> current;
		int answer = 0;

		for (int i = 0; i < current.length(); i++)
			answer += (current[i] - '0');
		
		printf("%d\n", answer);
	}
}