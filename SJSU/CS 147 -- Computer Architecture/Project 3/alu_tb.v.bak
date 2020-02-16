`timescale 1ns/1ps
`include "prj_definition.v"

module alu_tb;
wire zero;
wire [31:0] out;

reg [31:0] op2;
reg [31:0] op1;
reg [`ALU_OPRN_INDEX_LIMIT:0] oprn;

// module ALU(OUT, ZERO, OP1, OP2, OPRN);
ALU alu(.OUT(out), .ZERO(zero), .OP1(op1), .OP2(op2), .OPRN(oprn));

initial 
begin

op1 = 5000; op2 = 5000; oprn = 1;    // add
#5 op1 = 15; op2 = 15; oprn = 2; // sub
#5 op1 = 15; op2 = 5; oprn = 3; // mul
#5 op1 = 15; op2 = 5; oprn = 4; // shift R
#5 op1 = 15; op2 = 5; oprn = 5; // shift L
#5 op1 = 15; op2 = 5; oprn = 6; // and
#5 op1 = 15; op2 = 5; oprn = 7; // or
#5 op1 = 15; op2 = 5; oprn = 8; // nor
#5 op1 = 15; op2 = 5; oprn = 9; // slt
#5 ;
end

endmodule