`timescale 1ns/1ps
`include "prj_definition.v"

module mult_tb;
//reg SnA;
//wire CO, S;
wire [31:0] HI;
wire [31:0] LO;

reg [31:0] A;
reg [31:0] B;

wire [31:0] signed_HI;
wire [31:0] signed_LO;

reg [31:0] signed_A;
reg [31:0] signed_B;

// module MULT32_U(HI, LO, A, B);
// module MULT32(HI, LO, A, B);
MULT32_U mult(.HI(HI), .LO(LO), .A(A), .B(B));
MULT32 signedMult(.HI(signed_HI), .LO(signed_LO), .A(signed_A), .B(signed_B));

initial 
begin
#5 A=0; B=0; signed_A=0; signed_B=0;
#5 A=10; B=2; signed_A=10; signed_B=-2; 
#5 A=1; B=10; signed_A=1; signed_B=10; 
#5 A=100; B=100; signed_A=100; signed_B=100;
#5 A=99990; B=2; signed_A=99990; signed_B=-2; 
#5 A=32'b1111111111111111111111111111111; B=2; signed_A=32'b1111111111111111111111111111111; signed_B=2;
#5 ;
end

endmodule