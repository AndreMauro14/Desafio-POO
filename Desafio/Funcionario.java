public class Funcionario {
    private String nome;
    private double salarioBruto;
    private String funcao;

    public Funcionario(String nome,String funcao,  double salarioBruto) {
        this.nome = nome;
        this.funcao=funcao;
        this.salarioBruto=salarioBruto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double inss (){
        double salarioBruto = this.salarioBruto;
        double descontoInss=0.0;
        if (salarioBruto<=1412.00){
            descontoInss=salarioBruto*0.075;

        } else if (salarioBruto<=2666.68){
            descontoInss=1412.00*0.075+
                    ((salarioBruto-1412.00)*0.09);

        } else if  (salarioBruto<=4000.03){
            descontoInss=1412.00*0.075+
                    ((2666.68-1412.00)*0.09)+
                    ((salarioBruto-2666.68)*0.12);

        } else if (salarioBruto<7786.02) {
            descontoInss=1412.00*0.075+
                    ((2666.68-1412.00)*0.09)+
                    ((4000.02-2666.68)*0.12)+
                    ((salarioBruto-4000.02)*0.14);
        } else {
            descontoInss=1412.00*0.075+
                    ((2666.68-1412.00)*0.09)+
                    ((4000.02-2666.68)*0.12)+
                    ((7786.02-4000.02)*0.14);
        }
        return descontoInss;
    }
    public double impostoDeRenda (){
        double salarioBruto = this.salarioBruto;
        double descontoIDR = 0.0;
        if (salarioBruto<=2824.00){
            descontoIDR=0.0;

        } else if (salarioBruto<=3751.05) {
            descontoIDR=(salarioBruto * 0.075)-142.80;

        } else if (salarioBruto<=4664.68) {
            descontoIDR=(salarioBruto*0.15)-354.80;

        } else if (salarioBruto<=5807.38) {
            descontoIDR=(salarioBruto*0.225)-636.13;

        }else {
            descontoIDR=(salarioBruto*0.275)-869.36;
        }
        return descontoIDR;
    }
    public double valeTransporte(){
        double salarioBruto=this.salarioBruto;
        double descontoVT = salarioBruto * 0.06;
        return descontoVT;
    }
    public double SalarioLiquido (){
        double descontoINSS = inss();
        double descontoIDR = impostoDeRenda();
        double descontoVT= valeTransporte();
        return salarioBruto-descontoIDR-descontoINSS-descontoVT;
    }
    public String toString(){
        return "-----DADOS DO FUNCIONARIO-----\n"
                + "NOME: "+nome
                + "\nFUNÇÃO: "+funcao
                + "\nSALARIO LIQUIDO: "+String.format("R$ %.2f\n",SalarioLiquido()) ;
    }
}
