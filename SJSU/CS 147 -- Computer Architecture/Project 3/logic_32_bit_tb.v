`timescale 1ns/1ps

module logic_32_bit_tb;
wire [31:0] Y_nor;
wire [31:0] Y_and;
wire [31:0] Y_inv;
wire [31:0] Y_or;

reg [31:0] A_nor;
reg [31:0] A_and;
reg [31:0] A_inv;
reg [31:0] A_or;

reg [31:0] B_nor;
reg [31:0] B_and;
reg [31:0] B_or;

//module NOR32_2x1(Y,A,B);
//module AND32_2x1(Y,A,B);
//module INV32_1x1(Y,A);
//module OR32_2x1(Y,A,B);
NOR32_2x1 nor_inst(.Y(Y_nor), .A(A_nor), .B(B_nor));
AND32_2x1 and_inst(.Y(Y_and), .A(A_and), .B(B_and));
INV32_1x1 inv_inst(.Y(Y_inv), .A(A_inv));
OR32_2x1  or_inst(.Y(Y_or), .A(A_or), .B(B_or));

initial 
begin
A_nor=10; B_nor=10; A_and=10; B_and=10; A_inv=10; A_or=10; B_or=10;
#15 A_nor=4; B_nor=4; A_and=4; B_and=4; A_inv=4;  A_or=4; B_or=4;
#15 A_nor=250; B_nor=100; A_and=1; B_and=10; A_inv=0; A_or=100; B_or=10;
#15 ;
end

endmodule