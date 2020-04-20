#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;
class account
{
	int acno;
	char name[50];
	int deposit;
	char type;
public:
	void create_account();          
	void show_account();
	void modify();
	void dep(int);
	void draw(int);
	void report() const;
	int retacno() const;
	int retdeposit() const;
	char rettype() const;
};


