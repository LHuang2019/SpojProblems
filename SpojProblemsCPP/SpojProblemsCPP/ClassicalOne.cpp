#include "stdafx.h"
#include "ClassicalOne.h"

/**
* Solved classical -> AP - Complete The Series (Easy), ID 11063
**/
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