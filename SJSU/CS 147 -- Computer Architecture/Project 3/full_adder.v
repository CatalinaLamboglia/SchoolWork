// Name: full_adder.v
// Module: FULL_ADDER
//
// Output: S : Sum
//         CO : Carry Out
//
// Input: A : Bit 1
//        B : Bit 2
//        CI : Carry In
//
// Notes: 1-bit full adder implementaiton.
// 
//
// Revision History:
//
// Version	Date		Who		email			note
//------------------------------------------------------------------------------------------
//  1.0     Sep 10, 2014	Kaushik Patra	kpatra@sjsu.edu		Initial creation
//------------------------------------------------------------------------------------------
`include "prj_definition.v"

module FULL_ADDER(S, CO, A, B, CI);
output S, CO;
input A, B, CI;

wire C, Y, S;
//wire CI, CO;
wire tempC, tempY;
assign S = Y;
HALF_ADDER ha_inst_1(.Y(tempY), .C(tempC), .A(A), .B(B));
HALF_ADDER ha_inst_2(.Y(Y), .C(C), .A(tempY), .B(CI));

or inst1(CO, C, tempC);

endmodule;
