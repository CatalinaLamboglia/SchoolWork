//#include <iostream>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    char line[1000];
    
    if(argv[1] == NULL)
    {
       // printf("No args\n");
        exit(0);
    }
    
    FILE *fp = fopen(argv[1], "r");
    if (fp == NULL)  // error opening
    {
        printf("avg: cannot open file\n");
        exit(1);
    }

    //didnt exit so read  from file
    int count = 0;
    double sum = 0;
    double lineDouble;
    char *pointer;

    //parse lines
    while(fgets(line, 1000, fp))
    {
        lineDouble = strtod(line, &pointer);
        sum = sum + lineDouble;
        count++; 
    }

    printf("%f\n", sum / count);
    fclose(fp);

    exit(0);
    return 0;
}
