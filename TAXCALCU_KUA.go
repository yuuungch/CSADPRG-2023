/*
Using one of the specified programming languages (i.e. Go, Kotlin, R, and Ruby), your
group is asked to implement a Tax Calculator for the revised Philippine Tax Table for
2022. Given the monthly income, the calculator will automatically compute for (1) the
monthly income tax, (1) the monthly SSS, Pag-ibig and Philhealth contributions, (3) the
total deductions, and (4) the net monthly pay. You may refer to
https://taxcalculatorphilippines.com/ for how these items are computed.
Please note that you’re only required one implementation (i.e., usage of one language),
so your group is allowed to select a programming language from what was specified.
However, despite only being required to use one language, your group would best
explore each of the four languages for their strengths and weaknesses before
implementation. Some languages may not be a good fit for the problem described above
despite having the capacity to solve the problem. It might be beneficial for your group to
explore implementation in other languages – particularly as you’re expected to discuss
the strengths and weaknesses of each of the languages in the evaluation paper.
*/
package main
import "fmt"
func sssTax(money float32) float32 {
	// Used SSS online calculator formula
	return money * 0.045 
}

func PhilhealthTax(money float32) float32 {
	// Used PhilHealth online calculator formula
	return money * 0.0225
}

func PagIBIGTax(money float32) float32 {
	// Used PagIBIG online calculator formula
	if money <= 1500{
		return money * 0.01
	} else {
		return 100
	}
}

func ContribTax(sss, philhealth, pagibig float32) float32{
	return sss + philhealth + pagibig
}

func TaxableIncome(contribtax, money float32) float32{
	return money - contribtax 
}

func WithholdingTax(taxableincome, compensation, compensationrate, bonus float32) float32{
	return bonus + ((taxableincome - compensation) * compensationrate) 
}

func IncomeTax(taxableincome float32) float32 {
	var compensationrate, compensation, bonus float32
	if taxableincome <= 20833 {
		compensation = 0
		compensationrate = 0
		bonus = 0
	} else if taxableincome > 20833 && taxableincome <= 33332 {
		compensationrate = 0.2
		compensation = 20833
		bonus = 0
	} else if taxableincome > 33333 && taxableincome <= 66666 {
		compensationrate = 0.25
		compensation = 33333
		bonus = 2500
	} else if taxableincome > 66667 && taxableincome <= 166666 {
		compensationrate = 0.3
		compensation = 66667
		bonus = 10833.33
	} else if taxableincome > 166667 && taxableincome <= 666666 {
		compensationrate = 0.32
		compensation = 166667
		bonus = 40833.33 
	} else if taxableincome > 666667 {
		compensationrate = 0.35
		compensation = 666667
		bonus = 200833.33
	}
	return WithholdingTax(taxableincome, compensation, compensationrate, bonus)  	
}

func main(){
	// User's input of balance
	var money float32
	// User's contribution taxes
	var sss, pagibig, philhealth, contribtax, taxableincome float32 = 0, 0, 0, 0, 0
	// User's Income Tax
	var incometax float32
	// User's net pay
	var netpay_afterTax, netpay_afterDeductions float32 
	// Get Input
	fmt.Scanln(&money)
	// Contributions Computation
	sss = sssTax(money)
	pagibig = PagIBIGTax(money)
	philhealth = PhilhealthTax(money)
	contribtax = ContribTax(sss, philhealth, pagibig)
	taxableincome = TaxableIncome(contribtax, money) 
	// Income Tax Computation
	incometax = IncomeTax(taxableincome)
	// Compute net pay
	netpay_afterDeductions = money - incometax - contribtax
	netpay_afterTax = money - incometax
	// Output results
	fmt.Println("----------------------------------------")
	fmt.Printf("SSS: %.2f\n", sss)
	fmt.Printf("PhilHealth: %.2f\n", philhealth)
	fmt.Printf("Pag-IBIG: %.2f\n", pagibig)
	fmt.Printf("Total Contributions: %.2f\n", contribtax)
	fmt.Println("----------------------------------------")
	fmt.Printf("Income Tax: %.2f\n", incometax)	
	fmt.Println("----------------------------------------")
	fmt.Printf("Net pay after Income Tax: %.2f\n", netpay_afterTax)
	fmt.Printf("Net pay after Deductions: %.2f\n", netpay_afterDeductions)
	fmt.Println("----------------------------------------")	
}