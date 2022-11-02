package Modelo;

public class ValidarFase01 {
    private  String cadena;
    private  String tipo;
    private String instrucciones01 [] = {"aaa","clc","cmpsw","into","movsb","pusha","dec","idiv","int","not","adc","cmp","les","rcl","ja","jc","jge","jna","jnc","jnl"};
    private String instrucciones03 [] = {"pushf","sti","aam","cli","daa","lahf","mul","inc","neg","push","mov","ror","sub"};
    private String instrucciones04 [];
    private String instrucciones05 [];
    private String instrucciones06 [];
    private String instrucciones07 [];
    private String instrucciones08 [];
    private String instrucciones09 [];
    private String instrucciones10 [];
    private String instruccionesE02 [] = {"std","aad","cld","cwd","iret","movsw","div","imul","pop","idiv","shl","xchg","add","lds","jns","js","loopne","jae","jcxz","jl"};
    private String registros [] = {"ah","al","ax","bh","bl","bx","ch","cl","cx","dh","dl","dx","sp","bp","si","di","cs","ds", "es", "ss", "ip"};

    public ValidarFase01(String cadena){
        this.cadena = cadena;
        this.tipo = "";

        validarPseudoInstrucciones(this.cadena);

    }


    public void validarPseudoInstrucciones(String palabra){
        if(palabra.equalsIgnoreCase("stack segment") || palabra.equalsIgnoreCase(".stack")
                || palabra.equalsIgnoreCase(".stack segment") || palabra.equalsIgnoreCase("data segment")
                || palabra.equalsIgnoreCase(".data") || palabra.equalsIgnoreCase(".data segment")
                || palabra.equalsIgnoreCase("code segment") || palabra.equalsIgnoreCase(".code")
                || palabra.equalsIgnoreCase(".code segment") || palabra.equalsIgnoreCase("dw")
                || palabra.equalsIgnoreCase("db") || palabra.equalsIgnoreCase("equ")
                || (palabra.startsWith("dup") && palabra.endsWith(")")) || palabra.equalsIgnoreCase("macro")
                || palabra.equalsIgnoreCase("endm") || palabra.equalsIgnoreCase("proc")
                || palabra.equalsIgnoreCase("endp") || palabra.equalsIgnoreCase("ends")
                || (palabra.startsWith("DUP") && palabra.endsWith(")")) || palabra.equalsIgnoreCase("byte ptr")
                || palabra.equalsIgnoreCase("word ptr")){
            this.tipo = "\tPseudoinstruccion";
        }
    }


}
