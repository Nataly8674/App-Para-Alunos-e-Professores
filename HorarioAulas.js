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
          <Text style={styles.textoHeader}>Horário das Aulas</Text>
          <TouchableOpacity onPress={() => navigation.navigate("PainelInicial")}>
            <Image source={require('./assets/IMG/seta1.png')} style={[styles.seta]} />
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
        <Text style={styles.textoMateria1}>Português</Text>
        
        <Text style={styles.textoHorario1}>7:45 - 9:30</Text>

        <TouchableOpacity onPress={() => setIsExpanded(!isExpanded)}>
          <Text style={styles.textoConteudoMinistrado1}>
            {isExpanded ? "Ocultar conteúdo" : "Conteúdo que será ministrado"}
          </Text>
        </TouchableOpacity>

        <Image source={require('./assets/IMG/ImgLivro.png')} style={[styles.ImgLivro]} />

        {/* Conteúdo oculto */}
        {isExpanded && (
          <View style={styles.conteudoOculto}>
            <Text style={styles.textoConteudoOculto}>Exemplo de conteúdo a ser ministrado na aula de Português.</Text>
          </View>
        )}
      </View>

      {/*Sombra para Caixa Materia 1*/}
      <View style={styles.rectanglesContainer2}>
        <LinearGradient 
          colors={['#092d5e', '#2F80ED']} style={styles.retangulo2}/>
      </View>

      {/*Linha Caixa Materia 1*/}
      <View style={styles.linha1}/>
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
    bottom: 302,
  },

  textoHeader: {
    fontSize: 24,
    color: '#0073e6',
    marginTop: 10,
    textAlign: 'center',
    fontFamily: 'Nunito-VariableFont_wght',
    right: 25,
  },

  seta: {
    width: 30,
    height: 30,
    marginTop: 13,
    right: 30,
  },

  headerContent: {
    flexDirection: 'row-reverse',
    alignItems: 'center',
    justifyContent: 'center',
    marginRight: 110,
    marginLeft: 30,
  },

  /*Sombra para o Header*/
  rectanglesContainer: {
    bottom: 302,
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
  caixaMateria1Expandida: {
    height: 150, 
  },

  textoMateria1: {
    fontSize: 22,
    color: '#0073e6',
    marginTop: 10,
    textAlign: 'center',
    fontFamily: 'Nunito-VariableFont_wght',
    right: 28,
  },

  textoHorario1: {
    fontSize: 15,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
    left: 208,
    bottom: 25,
  },

  textoConteudoMinistrado1: {
    fontSize: 14,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
    left: 80,
    bottom: 16,
  },

  ImgLivro: {
    width: 55,
    height: 55,
    bottom: 75,
    left: 5,
  },

  /*Conteúdo oculto quando expandido*/
  conteudoOculto: {
    marginTop: 10,
    paddingHorizontal: 10,
  },
  textoConteudoOculto: {
    fontSize: 14,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
  },

  /*Sombra para Caixa Materia 1*/
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

  /*Separação Materia do Horario - Caixa Materia 1*/
  linha1: {
    height: 23,
    width: 1.5,
    bottom: 333,
    left: 41,
    backgroundColor: '#003F98',
  },
});
