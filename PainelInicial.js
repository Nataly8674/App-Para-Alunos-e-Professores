import React, { useState } from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity, Dimensions } from 'react-native';
import LinearGradient from 'react-native-linear-gradient'; // Importando o LinearGradient

const { width } = Dimensions.get('window'); // Importando as dimensões da tela

export default function HorarioAulas({ navigation }) {
  const [isExpanded, setIsExpanded] = useState(false); // Estado para controlar expansão da caixa

  return (
    <View style={styles.container}>
      
      {/*Header*/}
      <View style={styles.header}>
        <View style={styles.headerContent}>
          <Text style={styles.textoHeader}>Painel Inicial</Text>
          <TouchableOpacity onPress={() => navigation.navigate("HorarioAulas")}>
            <Image source={require('D:/Repositorios Git Hub/App-Para-Alunos-e-Professores/assets/IMG/seta1.png')} style={[styles.Seta]} />
          </TouchableOpacity>
        </View>
      </View>

      {/*Sombra para o Header*/} 
      <View style={styles.rectanglesContainer}>
        <LinearGradient 
          colors={['#092d5e', '#2F80ED']} style={styles.retangulo1}/>
      </View>

      {/*Caixa Materia 1*/}
      <View style={[styles.caixaMateria1, isExpanded && styles.caixaMateria1Expandida]}>
        <Text style={styles.textoMateria1}>Horários</Text>

        <Image source={require('D:/Repositorios Git Hub/App-Para-Alunos-e-Professores/assets/IMG/ImgLivro.png')} style={[styles.ImgCalendario]} />

      </View>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#2F80ED',
  },

  /*Header*/
  header: {
    width: 400,
    height: 55,
    backgroundColor: "#fff",
    elevation: 30,
    bottom: 318,
  },

  textoHeader: {
    fontSize: 24,
    color: '#0073e6',
    marginTop: 10,
    textAlign: 'center',
    fontFamily: 'Nunito-VariableFont_wght',
    right: 50,
  },

  Seta: { /*Avaliar necessidade*/
    width: 30,
    height: 30,
    marginTop: 13,
    right: 30,
  },

  headerContent: {
    flexDirection: 'row-reverse',
    alignItems: 'center',
    justifyContent: 'center',
    marginRight: 160,
    marginLeft: 30,
  },

  /*Sombra para o Header*/
  rectanglesContainer: {
    bottom: 318,
    width: width,
  },
  
  retangulo1: {
    height: 8,
    width: '100%',
    alignSelf: 'center',
  },

  /*Caixa Materia 1*/
  caixaMateria1: {
    backgroundColor: '#fff',
    height: 80, 
    width: 300,
    borderRadius: 10,
    bottom: 260,
    overflow: 'hidden', 
  },

  textoMateria1: {
    fontSize: 22,
    color: '#0073e6',
    marginTop: 10,
    textAlign: 'center',
    fontFamily: 'Nunito-VariableFont_wght',
    right: 28,
  },


  ImgCalendario: { /*Substituir por calendario*/ 
    width: 55,
    height: 55,
    bottom: 75,
    left: 5,
  },

  /*Sombra para Caixa Materia 1*/ /*Avaliar*/
  rectanglesContainer2: {
    bottom: 273,
    width: 280,
  },

  retangulo2: {
    height: 8,
    width: '100%',
    alignSelf: 'center',
    borderRadius: 10,
  },


});