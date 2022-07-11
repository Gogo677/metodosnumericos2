/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import metodos.*;

/**
 *
 * @author diego
 */
public class Ejecutor extends javax.swing.JFrame {
    
    int tipoMenu;
    List<Double> X,FX;
    Double vecX=null,vecY=null;
    int n;
  
    public Ejecutor(int tipoMenu) {
        initComponents();
        this.tipoMenu=tipoMenu;
        iniciador();
        setLocationRelativeTo(null);
    }
    
    public void iniciador(){
        
        botonTeoria.setVisible(false); //oculta el boton para volver a la teoria
        switch(tipoMenu){
            case 1:
            {
                this.nombreMetodo.setText("Método del Punto fijo");
                textoEntrada1.setText("X");
                textoEntrada2.setText("Y:");
                entrada1.setText("0");
                entrada2.setText("0");
                descripcionEntradas.setText("Introduce el vector inicial (x,y)");
                datosExtra.setText("");
                numEntradas.setVisible(false);
                actualizaTeoria("1_PuntoFijo");
                botonAgregar.setText("Actualiza Vector");
                botonReiniciar.setVisible(false);
                break;
            }
            case 2:
            {
                this.nombreMetodo.setText("Método del Newton - Raphson");
                textoEntrada1.setText("X");
                textoEntrada2.setText("Y:");
                entrada1.setText("0");
                entrada2.setText("0");
                descripcionEntradas.setText("Introduce el vector inicial (x,y)");
                datosExtra.setText("");
                numEntradas.setVisible(false);
                actualizaTeoria("1_NewtonRaphson");
                botonAgregar.setText("Actualiza Vector");
                botonReiniciar.setVisible(false);
                break;
            }
            case 3:
            {
                this.nombreMetodo.setText("Interpolación de Newton");
                textoEntrada1.setText("X:");
                textoEntrada2.setText("FX:");
                entrada1.setText("0");
                entrada2.setText("0");
                descripcionEntradas.setText("Introduce las X y sus evaluaciones FX");
                datosExtra.setText("Introduce 4 puntos");
                X = new ArrayList();
                FX = new ArrayList();
                n=0;
                iniciaListaIntegracion();
                actualizaTeoria("2_InterpolacionNewton");
                break;
            }
            case 4:
            {
                this.nombreMetodo.setText("Método de Trapezoidal");
                textoEntrada1.setText("X:");
                textoEntrada2.setText("FX:");
                entrada1.setText("0");
                entrada2.setText("0");
                descripcionEntradas.setText("Introduce las X y sus evaluaciones FX");
                datosExtra.setText("Las n entradas deben ser al menos 3");
                X = new ArrayList();
                FX = new ArrayList();
                n=0;
                iniciaListaIntegracion();
                actualizaTeoria("3_Trapecio");
                break;
            }
            case 5:
            {
                this.nombreMetodo.setText("Método de Simpson 1/3");
                textoEntrada1.setText("X:");
                textoEntrada2.setText("FX:");
                entrada1.setText("0");
                entrada2.setText("0");
                descripcionEntradas.setText("Introduce las X y sus evaluaciones FX");
                datosExtra.setText("Las n entradas deben ser 3, 5, 7, 9, ...");
                X = new ArrayList();
                FX = new ArrayList();
                n=0;
                iniciaListaIntegracion();
                actualizaTeoria("3_SimpsonUnTercio");
                break;
            }
            case 6:
            {
                this.nombreMetodo.setText("Método de Simpson 3/8");
                textoEntrada1.setText("X:");
                textoEntrada2.setText("FX:");
                entrada1.setText("0");
                entrada2.setText("0");
                descripcionEntradas.setText("Introduce las X y sus evaluaciones FX");
                datosExtra.setText("Las n entradas deben ser 4, 7, 10, 13, ...");
                X = new ArrayList();
                FX = new ArrayList();
                n=0;
                iniciaListaIntegracion();
                actualizaTeoria("3_SimpsonTresOctavos");
                break;
            }
        }
    }
    
    public void actualizaTeoria(String teoria){
        try {
                cajaTexto.read((new InputStreamReader(getClass().getResourceAsStream("/teoria/"+teoria+".txt"), "UTF-8")),null);
            } catch (IOException ex) {
                Logger.getLogger(Ejecutor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void iniciaListaIntegracion(){
        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "X0 FX0"};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
            });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreMetodo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaTexto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        textoEntrada1 = new javax.swing.JLabel();
        entrada1 = new javax.swing.JTextField();
        textoEntrada2 = new javax.swing.JLabel();
        entrada2 = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonEjecuta = new javax.swing.JButton();
        botonTeoria = new javax.swing.JButton();
        descripcionEntradas = new javax.swing.JLabel();
        datosExtra = new javax.swing.JLabel();
        numEntradas = new javax.swing.JLabel();
        botonReiniciar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("metodo");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        nombreMetodo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        nombreMetodo.setText("Nombre del método");

        cajaTexto.setEditable(false);
        cajaTexto.setColumns(20);
        cajaTexto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cajaTexto.setLineWrap(true);
        cajaTexto.setRows(5);
        cajaTexto.setText("Aquí va la parte teorica \n\nAhora unas plabras para mis queridos camaradas que van mas alla del espacio ya que les quiero demostrar como las lineas se siguen escribiendo sin adaptar nada");
        cajaTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(cajaTexto);

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel2.setText("Prueba el método:");

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "No hay datos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lista);

        textoEntrada1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        textoEntrada1.setText("Entrada1:");

        entrada1.setText("valor1");

        textoEntrada2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        textoEntrada2.setText("Entrada2:");

        entrada2.setText("valor2");

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEjecuta.setText("Ejecutar metodo");
        botonEjecuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutaActionPerformed(evt);
            }
        });

        botonTeoria.setText("Volver a ver la teoría");
        botonTeoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTeoriaActionPerformed(evt);
            }
        });

        descripcionEntradas.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        descripcionEntradas.setText("Descripcion de las entradas");

        datosExtra.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        datosExtra.setText("Datos extra");

        numEntradas.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        numEntradas.setText("Num entradas: 0");

        botonReiniciar.setText("Reiniciar");
        botonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReiniciarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/volver.png"))); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datosExtra)
                    .addComponent(descripcionEntradas)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEjecuta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numEntradas)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textoEntrada1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textoEntrada2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entrada2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(botonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonReiniciar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreMetodo))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonTeoria, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreMetodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(botonTeoria, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datosExtra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEntrada1)
                    .addComponent(entrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoEntrada2)
                    .addComponent(entrada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregar)
                    .addComponent(botonReiniciar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(numEntradas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEjecuta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        switch(tipoMenu){
            case 1:
            {
                vecX=Double.parseDouble(entrada1.getText());
                vecY=Double.parseDouble(entrada2.getText());
                String[] lista = new String[1];
                lista[0]="(x,y) = ("+vecX+","+vecY+")";
                this.lista.setListData(lista);
                break;
            }
            case 2:
            {
                vecX=Double.parseDouble(entrada1.getText());
                vecY=Double.parseDouble(entrada2.getText());
                String[] lista = new String[1];
                lista[0]="(x,y) = ("+vecX+","+vecY+")";
                this.lista.setListData(lista);
                break;
            }
            case 3:
            {
                X.add(Double.parseDouble(entrada1.getText()));
                FX.add(Double.parseDouble(entrada2.getText()));
                n++;
                numEntradas.setText("Num entradas: "+n);
                String[] lista = new String[X.size()];
                for(int i=0;i<X.size();i++){
                    lista[i]="X: "+X.get(i)+" FX: "+FX.get(i);
                }
                this.lista.setListData(lista);
                break;
            }
            case 4:
            {
                X.add(Double.parseDouble(entrada1.getText()));
                FX.add(Double.parseDouble(entrada2.getText()));
                n++;
                numEntradas.setText("Num entradas: "+n);
                String[] lista = new String[X.size()];
                for(int i=0;i<X.size();i++){
                    lista[i]="X: "+X.get(i)+" FX: "+FX.get(i);
                }
                this.lista.setListData(lista);
                break;
            }
            case 5:
            {
                X.add(Double.parseDouble(entrada1.getText()));
                FX.add(Double.parseDouble(entrada2.getText()));
                n++;
                numEntradas.setText("Num entradas: "+n);
                String[] lista = new String[X.size()];
                for(int i=0;i<X.size();i++){
                    lista[i]="X: "+X.get(i)+" FX: "+FX.get(i);
                }
                this.lista.setListData(lista);
                break;
            }
            case 6:
            {
                X.add(Double.parseDouble(entrada1.getText()));
                FX.add(Double.parseDouble(entrada2.getText()));
                n++;
                numEntradas.setText("Num entradas: "+n);
                String[] lista = new String[X.size()];
                for(int i=0;i<X.size();i++){
                    lista[i]="X: "+X.get(i)+" FX: "+FX.get(i);
                }
                this.lista.setListData(lista);
                break;
            }
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReiniciarActionPerformed
        switch(tipoMenu){
            case 1:
            {
                //nada
                break;
            }
            case 2:
            {
                //nada
                break;
            }
            case 3:
            {
                X.clear();
                FX.clear();
                n=0;
                numEntradas.setText("Num entradas: "+n);
                iniciaListaIntegracion();
                break;
            }
            case 4:
            {
                X.clear();
                FX.clear();
                n=0;
                numEntradas.setText("Num entradas: "+n);
                iniciaListaIntegracion();
                break;
            }
            case 5:
            {
                X.clear();
                FX.clear();
                n=0;
                numEntradas.setText("Num entradas: "+n);
                iniciaListaIntegracion();
                break;
            }
            case 6:
            {
                X.clear();
                FX.clear();
                n=0;
                numEntradas.setText("Num entradas: "+n);
                iniciaListaIntegracion();
                break;
            }
        }
    }//GEN-LAST:event_botonReiniciarActionPerformed

    private void botonEjecutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutaActionPerformed
        botonTeoria.setVisible(true);
        switch(tipoMenu){
            case 1:
            {
                if(vecX==null || vecY== null){
                 JOptionPane.showMessageDialog(null, "Verfica los datos de entrada");
                }else{
                    PuntoFijo met =new PuntoFijo(vecX,vecY);
                    cajaTexto.setText(met.metodo());
                }
                break;
            }
            case 2:
            {
                if(vecX==null || vecY== null){
                    JOptionPane.showMessageDialog(null, "Verfica los datos de entrada");
                }else{
                    cajaTexto.setLineWrap(false);
                    NewtonRaphson met = new NewtonRaphson(vecX,vecY);
                    cajaTexto.setText(met.metodo());
                }
                break;
            }
            case 3:
            {
                if(n!=4){
                    JOptionPane.showMessageDialog(null, "Verifica que la tabla sea de 4");
                }else{
                    Double X[] = new Double[this.X.size()];
                    Double FX[] = new Double[this.FX.size()];
                    this.X.toArray(X);
                    this.FX.toArray(FX);
                    InterpolacionNewton met = new InterpolacionNewton(X,FX,n);
                    cajaTexto.setText(met.metodo());
                }
                break;
            }
            case 4:
            {
                if(n>=3){                   
                    Double X[] = new Double[this.X.size()];
                    Double FX[] = new Double[this.FX.size()];
                    this.X.toArray(X);
                    this.FX.toArray(FX);
                    Trapezoidal sim = new Trapezoidal(X,FX,n);
                    cajaTexto.setText(sim.metodo());
                }else{
                    JOptionPane.showMessageDialog(null, "Verifica el numero de entradas");
                }
                break;
            }
            case 5:
            {
                if(n==3 || n==5 || n==7 || n==9 || n==11 ){                   
                    Double X[] = new Double[this.X.size()];
                    Double FX[] = new Double[this.FX.size()];
                    this.X.toArray(X);
                    this.FX.toArray(FX);
                    SimpsonUnTercio sim = new SimpsonUnTercio(X,FX,n);
                    cajaTexto.setText(sim.metodo());
                }else{
                    JOptionPane.showMessageDialog(null, "Verifica el numero de entradas");
                }
                break;
            }
            case 6:
            {
                if(n==4 || n==7 || n==10 || n==13 || n==16 ){                   
                    Double X[] = new Double[this.X.size()];
                    Double FX[] = new Double[this.FX.size()];
                    this.X.toArray(X);
                    this.FX.toArray(FX);
                    SimpsonTresOctavos sim = new SimpsonTresOctavos(X,FX,n);
                    cajaTexto.setText(sim.metodo());
                }else{
                    JOptionPane.showMessageDialog(null, "Verifica el numero de entradas");
                }
                break;
            }
        }
    }//GEN-LAST:event_botonEjecutaActionPerformed
 // terminado¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿'
    private void botonTeoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTeoriaActionPerformed
        botonTeoria.setVisible(false);
        switch(tipoMenu){
            case 1:
            {
                actualizaTeoria("1_PuntoFijo");
                break;
            }
            case 2:
            {
                cajaTexto.setLineWrap(true);
                actualizaTeoria("1_NewtonRaphson");
                break;
            }
            case 3:
            {
                actualizaTeoria("2_InterpolacionNewton");
                break;
            }
            case 4:
            {
                actualizaTeoria("3_Trapecio");
                break;
            }
            case 5:
            {                                 
            actualizaTeoria("3_SimpsonUnTercio");
                break;
            }
            case 6:
            {
                actualizaTeoria("3_SimpsonTresOctavos");
                break;
            }
        }
    }//GEN-LAST:event_botonTeoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Inicio ven = null;
        if(tipoMenu==1 || tipoMenu==2){
            ven = new Inicio(1);
        }else
        if(tipoMenu==3){
            ven = new Inicio(2);
        }else
        if(tipoMenu==4 || tipoMenu==5 || tipoMenu==6){
            ven = new Inicio(3);
        }else{
            ven = new Inicio(1);
        }
        ven.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEjecuta;
    private javax.swing.JButton botonReiniciar;
    private javax.swing.JButton botonTeoria;
    private javax.swing.JTextArea cajaTexto;
    private javax.swing.JLabel datosExtra;
    private javax.swing.JLabel descripcionEntradas;
    private javax.swing.JTextField entrada1;
    private javax.swing.JTextField entrada2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lista;
    private javax.swing.JLabel nombreMetodo;
    private javax.swing.JLabel numEntradas;
    private javax.swing.JLabel textoEntrada1;
    private javax.swing.JLabel textoEntrada2;
    // End of variables declaration//GEN-END:variables
}
