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
          <TouchableOpacity onPress={() => navigation.navigate("TelaLogin")}>
            <Image source={require('../app/assets/IMG/seta1.png')} style={[styles.Seta]} />
          </TouchableOpacity>
        </View>
      </View>

      {/*Sombra para o Header*/} 
      <View style={styles.rectanglesContainer}>
        <LinearGradient 
          colors={['#092d5e', '#2F80ED']} style={styles.retangulo1}/>
      </View>

      {/*Caixa Materia 1*/}
      <TouchableOpacity onPress={() => navigation.navigate("HorarioAulas")}>
        <View style={[styles.caixaMateria1, isExpanded && styles.caixaMateria1Expandida]}>
          <Text style={styles.textoMateria1}>Horários das Aulas</Text>
    
          <Image source={require('../app/assets/IMG/Calendario.png')} style={[styles.ImgCalendario]} />

        </View>
      </TouchableOpacity>
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
    bottom: 290,
    overflow: 'hidden',
    borderColor: 'black',
    borderWidth: 1,
  },

  textoMateria1: {
    fontSize: 22,
    color: '#0073e6',
    marginTop: 23,
    left: 20,
    textAlign: 'center',
    fontFamily: 'Nunito-VariableFont_wght',
    borderRadius: 10,
  },


  ImgCalendario: { /*Substituir por calendario*/ 
    width: 70,
    height: 70,
    bottom: 45,
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

