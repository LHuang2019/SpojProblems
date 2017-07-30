#include "stdafx.h"
#include "ClassicalOne.h"
#include <iostream>
#include <algorithm>
#include <string>
#include <set>
#include <unordered_map>
#include <unordered_set>
#include <functional>

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

/*
Solved classical -> The Mirror of Galadriel, ID 13043
*/
void ClassicalOne::amr12d()
{
	int numInput;
	string current, rev;
	scanf("%d", &numInput);

	while (numInput--)
	{
		cin >> current;
		rev = current;
		reverse(rev.begin(), rev.end());
		cout << (current == rev ? "YES" : "NO") << "\n";
	}
}

/*
Solved classical -> Majority, ID 6171
*/
void ClassicalOne::major()
{
	int numInput, numCurrent, current;
	scanf("%d", &numInput);

	outerLoop:
	while (numInput--)
	{
		scanf("%d", &numCurrent);
		
		if (numCurrent == 0)
		{
			printf("NO\n");
			goto outerLoop;
		}

		unordered_map<int, int> umap;

		for (int i = 0; i < numCurrent; i++)
		{
			scanf("%d", &current);
			umap[current] = umap.find(current) == umap.end() ? 1 : umap[current] + 1;
		}

		int max = 0;
		for (pair<int, int> element : umap)
		{
			if (element.second > numCurrent / 2)
			{
				printf("YES %d\n", element.first);
				goto outerLoop;
			}
			max += element.second;

			if (max >= (numCurrent + numCurrent % 2))
			{
				printf("NO\n");
				goto outerLoop;
			}
		}
		printf("NO\n");
	}
}

/*
Solved classical -> Between the Mountains, ID 10239
*/
void ClassicalOne::acpc11b()
{
	int numInput, nA, nB, current;
	scanf("%d", &numInput);

	outerLoop:
	while (numInput--)
	{
		set<int> setA, setB;

		scanf("%d", &nA);
		while (nA--)
		{
			cin >> current;
			setA.insert(current);
		}

		scanf("%d", &nB);
		while (nB--)
		{
			cin >> current;
			setB.insert(current);
		}

		int min = INT_MAX;
		innerLoop:
		for (const int &num : setA)
		{
			if (setB.find(num) != setB.end())
			{
				cout << 0 << "\n";
				goto outerLoop;
			}
			
			for (const int &num2 : setB)
			{
				if (abs(num - num2) >= min)
					continue;

				min = abs(num - num2);
			}
		}
		cout << min << "\n";
	}
}

/*
Solved classical -> AP - Common Permutation, ID 1728
*/
void ClassicalOne::cprmt()
{
	string str1, str2;
	while (cin >> str1 >> str2)
	{
		unordered_map<char, int> umapA, umapB;
		for (int i = 0; i < str1.length(); i++)
			umapA[str1[i]] = umapA.find(str1[i]) == umapA.end() ? 1 : umapA[str1[i]] + 1;
		

		for (int j = 0; j < str2.length(); j++)
			umapB[str2[j]] = umapB.find(str2[j]) == umapB.end() ? 1 : umapB[str2[j]] + 1;

		string ans;
		for (pair<char, int> element : umapA)
		{
			if (umapB.find(element.first) != umapB.end())
				ans += element.second < umapB[element.first] ? 
				string(element.second, element.first) : string(umapB[element.first], element.first);
		}

		sort(ans.begin(), ans.end());
		cout << ans << "\n";
	}
}

/*
Solved classical -> Hacking the random number generator, ID 9734
*/
void ClassicalOne::hackrndm() 
{
	unordered_set<int> uset;
	int n, k, current, count = 0;
	cin >> n >> k;

	for (int i = 0; i < n; i++)
	{
		cin >> current;
		uset.insert(current);
	}

	unordered_set<int>::iterator it;
	for (it = uset.begin(); it != uset.end();) {
		
		if (uset.find(*it + k) != uset.end())
			count++;
		if (uset.find(*it - k) != uset.end())
			count++;

		unordered_set<int>::iterator current = it++;
		uset.erase(current);
	}

	cout << count;
}

/*
Solved classical -> THE MAX LINES, ID 8670
*/
void ClassicalOne::maxln()
{
	int t, i = 0;
	cin >> t;
	while (i<t)
	{
		long long r;
		float ac = .5;
		double s;
		cin >> r;
		s = double(4 * r * r) + .25;
		printf("Case %d: %.2lf\n", ++i, s);
	}
}

/*
Solved classical -> Traversing Grid, ID 5976
*/
void ClassicalOne::trgrid()
{
	int numInput, m, n;
	string ans;
	cin >> numInput;
	while (numInput--)
	{
		cin >> n >> m;

		if (n % 2 == 0 && n <= m)
			ans = "L";
		else if (n % 2 == 1 && n <= m)
			ans = "R";
		else if (m % 2 == 1)
			ans = "D";
		else
			ans = "U";

		cout << ans << "\n";
	}
}

/* Solved classical -> DOTA HEROES, ID 10286 */
void ClassicalOne::dotaa()
{
	int numInput, n, m, d, current;
	cin >> numInput;
	while (numInput--)
	{
		cin >> n >> m >> d;
		while (n-- && m > 0)
		{
			cin >> current;
			if (current > d)
				m -= current % d == 0 ? current / d - 1 : current / d;
		}

		cout << (m <= 0 ? "YES" : "NO") << "\n";
	}
}

/* Solved classical problem Candy Distribution, ID 10442 */
long long c[100000];
long long p[100000];
void ClassicalOne::cadydist()
{
	int n;

	cin >> n;
	while (n != 0) 
	{
		for (int i = 0; i < n; i++)
			scanf("%lld", &c[i]);
		
		for (int j = 0; j < n; j++)
			scanf("%lld", &p[j]);

		sort(c, c + n);
		sort(p, p + n, greater<long long>());

		long long sum = 0;

		for (int k = 0; k < n; k++)
			sum += c[k] * p[k];

		cout << sum << "\n";
		cin >> n;
	}
}