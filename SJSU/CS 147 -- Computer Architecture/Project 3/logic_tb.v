`timescale 1ns/1ps
`include "prj_definition.v"

module logic_tb;
reg S, R, C;
reg nP, nR;
wire Q,Qbar;
wire D_Latch_Q, D_Latch_Qbar;
reg D_Latch_D, D_Latch_C;
wire FF_Q, FF_Qbar;
reg FF_D, FF_C, FF_nP, FF_nR;
reg reg_L;
wire reg_Q;

wire [31:0] D;
reg [4:0] I;
//wire [3:0] D;
//reg [1:0] I;

wire [31:0] Q_32;

reg CLK, LOAD;
reg [31:0] D_32;
reg RESET;

//module REG32(Q, D, LOAD, CLK, RESET);
//module SR_LATCH(Q, Qbar, S, R, C, nP, nR);
//module D_LATCH(Q, Qbar, D, C, nP, nR);
//module D_FF(Q, Qbar, D, C, nP, nR);
//module REG1(Q, Qbar, D, L, C, nP, nR);

//SR_LATCH sr_latch(.Q(Q), .Qbar(Qbar), .S(S), .R(R), .C(C), .nP(nP), .nR(nR));
//D_LATCH d_latch(.Q(D_Latch_Q), .Qbar(D_Latch_Qbar), .D(D_Latch_D), .C(D_Latch_C), .nP(nP), .nR(nR));
//D_FF flip_flop(.Q(FF_Q), .Qbar(FF_Qbar), .D(FF_D), .C(FF_C), .nP(FF_nP), .nR(FF_nR));

DECODER_5x32 decoder_5x32(.D(D),.I(I));  

//DECODER_2x4 D_2x4(.D(D[3:0]), .I(I[1:0]));
//REG1 single_reg(.Q(reg_Q), .Qbar(FF_Qbar), .D(FF_D), .L(reg_L), .C(FF_C), .nP(FF_nP), .nR(FF_nR));
REG32 reg_32(.Q(Q_32), .D(D_32), .LOAD(LOAD), .CLK(CLK), .RESET(RESET));



initial 
begin
/*
#15 LOAD = 0; CLK=1; D_32 = 50;  RESET = 1;
#15 LOAD = 0; CLK=0; D_32 = 50;  RESET = 1;
#15 LOAD = 1; CLK=1; D_32 = 500;  RESET = 0;
#15 LOAD = 0; CLK=0; D_32 = 1500;  RESET = 1;
#15 LOAD = 0; CLK=1; D_32 = 50000000;  RESET = 1;

#15 LOAD = 0; CLK=1; D_32 = 50; RESET = 1; 
#15 LOAD = 1; CLK=0; D_32 = 50; RESET = 0; 
#15 LOAD = 1; CLK=1; D_32 = 50000; RESET = 1; 
#15 LOAD = 0; CLK=0; D_32 = 9000; RESET = 1; 
*/

/*
#15 FF_D = 1; reg_L = 0; FF_C=1; FF_nP=1; FF_nR=1;
#15  FF_D = 1; reg_L = 1; FF_C=1; FF_nP=1; FF_nR=0;
#15  FF_D = 1; reg_L = 1; FF_C=1; FF_nP=0; FF_nR=0;
#15 FF_D = 1; reg_L = 0; FF_C=0; FF_nP=1; FF_nR=0; */

/*
#5 S=1; C=1; R=0; 
#5 S=0; C=1; R=1; 
#5 S=1; C=0; R=0; */

/*
#5  D_Latch_C=1; D_Latch_D=1;  
#5  D_Latch_C=1; D_Latch_D=0; 
#5  D_Latch_C=0; D_Latch_D=0; 
*/
/*
#5 FF_D=1; FF_C=1; FF_nR=0; FF_nP=0; reg_L =1; 
#5 FF_D=0; FF_C=1; FF_nR=0; FF_nP=1; reg_L =1; 
#5 FF_D=1; FF_C=1; FF_nR=1; FF_nP=1; reg_L =0;
#5 FF_D=1; FF_C=0; FF_nR=0; FF_nP=0; reg_L =1; 
*/
#5 ;  

#5 I = 0 ;
#5 I = 1 ;
#5 I = 2 ;
#5 I = 3 ;
#5 I = 4 ;
#5 I = 5 ;
#5 I = 6 ;
#5 I = 7 ;
#5 I = 8 ;
#5 I = 9 ;
#5 I = 10 ;
#5 I = 11 ;
#5 I = 12 ;
#5 I = 13 ;
#5 I = 14 ;
#5 I = 15 ;
#5 I = 16 ;
#5 I = 17 ;
#5 I = 18 ;
#5 I = 19 ;
#5 I = 20 ;
#5 I = 21 ;
#5 I = 22 ;
#5 I = 23 ;
#5 I = 24 ;
#5 I = 25 ;
#5 I = 26 ;
#5 I = 27 ;
#5 I = 28 ;
#5 I = 29 ;
#5 I = 30 ;
#5 I = 31 ; 
#5 ;

end
endmodule