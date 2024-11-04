import React, { useState } from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity, Dimensions,  ScrollView } from 'react-native';
import LinearGradient from 'react-native-linear-gradient'; // Importando o LinearGradient

const { width } = Dimensions.get('window'); // Importando as dimensões da tela

export default function HorarioAulas({ navigation }) {
  const [isExpanded1, setIsExpanded1] = useState(false); // Estado para controlar expansão da caixa 1
  const [isExpanded2, setIsExpanded2] = useState(false); 
  const [isExpanded3, setIsExpanded3] = useState(false); 
  const [isExpanded4, setIsExpanded4] = useState(false); 

  return (
    <View style={styles.container}>
      
      {/*Header*/}
      <View style={styles.header}>
        <View style={styles.headerContent}>
          <Text style={styles.textoHeader}>Horário das Aulas</Text>
          <TouchableOpacity onPress={() => navigation.navigate("PainelInicial")}>
            <Image source={require('../app/assets/IMG/seta1.png')} style={[styles.seta]} />
          </TouchableOpacity>
        </View>
      </View>

      {/*Sombra para o Header*/}
      <View style={styles.rectanglesContainer}>
        <LinearGradient 
          colors={['#092d5e', '#2F80ED']} style={styles.retangulo1}/>
      </View>

      {/* ScrollView para permitir rolagem vertical */}
      <ScrollView style={styles.scrollContainer}>

        <View style={styles.Main}>

          {/*--------------------------------------------------------------------*/}

          {/*Caixa Materia 1*/}
          <Text style={styles.DiaDaSemana}> Segunda - Feira | 12/08/2024</Text>

          <View style={[styles.caixaMateria1, isExpanded1 && styles.caixaMateria1Expandida]}>
            <Text style={styles.textoMateria1}>Português</Text>
        
            <View style={styles.linha1}/>
        
            <Text style={styles.textoHorario1}>7:45 - 9:30</Text>

            <TouchableOpacity onPress={() => setIsExpanded1(!isExpanded1)}>
              <Text style={styles.textoConteudoMinistrado1}>
                {isExpanded1 ? "Ocultar conteúdo" : "Conteúdo que será ministrado"}
              </Text>
            </TouchableOpacity>
  
            <Image source={require('../app/assets/IMG/ImgLivro.png')} style={[styles.ImgLivro]} />

            {/* Conteúdo oculto */}
            {isExpanded1 && (
              <View style={styles.conteudoOculto}>
                <Text style={styles.textoConteudoOculto}>Exemplo de conteúdo a ser ministrado na aula de Português.</Text>
                
                <View style={styles.botoesConteudoOculto}>
                <TouchableOpacity onPress={() => navigation.navigate("TelaChamada")}>
                  <Text style={styles.realizarChamada}>Realizar Chamada</Text>
                </TouchableOpacity>
                <TouchableOpacity>
                  <Text style={styles.Salvar}>Salvar</Text>
                </TouchableOpacity>
                </View>

              </View>
            )}
          </View>

          {/*--------------------------------------------------------------------*/}

          {/*Caixa Materia 2*/}
          <View style={[styles.caixaMateria2, isExpanded2 && styles.caixaMateria2Expandida]}>
            <Text style={styles.textoMateria2}>Matématica</Text>
        
            <View style={styles.linha2}/>
        
            <Text style={styles.textoHorario2}>9:30 - 11:30</Text>

            <TouchableOpacity onPress={() => setIsExpanded2(!isExpanded2)}>
              <Text style={styles.textoConteudoMinistrado2}>
                {isExpanded2 ? "Ocultar conteúdo" : "Conteúdo que será ministrado"}
              </Text>
            </TouchableOpacity>

            <Image source={require('../app/assets/IMG/ImgLampada.png')} style={[styles.ImgLampada]} />

            {/* Conteúdo oculto */}
            {isExpanded2 && (
              <View style={styles.conteudoOculto}>
              <Text style={styles.textoConteudoOculto}>Exemplo de conteúdo a ser ministrado na aula de Matemática.</Text>
              
              <View style={styles.botoesConteudoOculto}>
              <TouchableOpacity onPress={() => navigation.navigate("TelaChamada")}>
                <Text style={styles.realizarChamada}>Realizar Chamada</Text>
              </TouchableOpacity>
              <TouchableOpacity>
                <Text style={styles.Salvar}>Salvar</Text>
              </TouchableOpacity>
              </View>

            </View>
              
            )}
          </View>
        
          <View style={styles.LinhaSeparacaoDiaSemana1}/>

          {/*--------------------------------------------------------------------*/}

          {/*Caixa Materia 3*/}
          <Text style={styles.DiaDaSemana}> Terça - Feira | 13/08/2024</Text>

          <View style={[styles.caixaMateria1, isExpanded3 && styles.caixaMateria1Expandida]}>
            <Text style={styles.textoMateria1}>Geografia</Text>
        
            <View style={styles.linha3}/>
        
            <Text style={styles.textoHorario1}>11:30 - 12:45</Text>

            <TouchableOpacity onPress={() => setIsExpanded3(!isExpanded3)}>
              <Text style={styles.textoConteudoMinistrado1}>
                {isExpanded3 ? "Ocultar conteúdo" : "Conteúdo que será ministrado"}
              </Text>
            </TouchableOpacity>

            <Image source={require('../app/assets/IMG/globo.png')} style={[styles.ImgLivro]} />

            {/* Conteúdo oculto */}
            {isExpanded3 && (
              <View style={styles.conteudoOculto}>
              <Text style={styles.textoConteudoOculto}>Exemplo de conteúdo a ser ministrado na aula de Geografia.</Text>
              
              <View style={styles.botoesConteudoOculto}>
              <TouchableOpacity onPress={() => navigation.navigate("TelaChamada")}>
                <Text style={styles.realizarChamada}>Realizar Chamada</Text>
              </TouchableOpacity>
              <TouchableOpacity>
                <Text style={styles.Salvar}>Salvar</Text>
              </TouchableOpacity>
              </View>

            </View>
            )}
          </View>

          {/*--------------------------------------------------------------------*/}

          {/*Caixa Materia 4*/}
          <View style={[styles.caixaMateria2, isExpanded4 && styles.caixaMateria2Expandida]}>
            <Text style={styles.textoMateria2}>História</Text>
        
            <View style={styles.linha4}/>
        
            <Text style={styles.textoHorario2}>12:45 - 14:30</Text>

            <TouchableOpacity onPress={() => setIsExpanded4(!isExpanded4)}>
              <Text style={styles.textoConteudoMinistrado2}>
                {isExpanded4 ? "Ocultar conteúdo" : "Conteúdo que será ministrado"}
              </Text>
            </TouchableOpacity>

            <Image source={require('../app/assets/IMG/roma.png')} style={[styles.ImgLampada]} />

            {/* Conteúdo oculto */}
            {isExpanded4 && (
              <View style={styles.conteudoOculto}>
              <Text style={styles.textoConteudoOculto}>Exemplo de conteúdo a ser ministrado na aula de Historia.</Text>
              
              <View style={styles.botoesConteudoOculto}>
              <TouchableOpacity onPress={() => navigation.navigate("TelaChamada")}>
                <Text style={styles.realizarChamada}>Realizar Chamada</Text>
              </TouchableOpacity>
              <TouchableOpacity>
                <Text style={styles.Salvar}>Salvar</Text>
              </TouchableOpacity>
              </View>

            </View>
            )}
          </View>

          <View style={styles.LinhaSeparacaoDiaSemana1}/>

        </View>
        
      </ScrollView>
    </View>
    
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#2F80ED',
  },

  /*Header*/
  header: {
    width: '100%',
    height: 55,
    backgroundColor: "#fff",
    elevation: 30,
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
    width: width,
  },

  retangulo1: {
    height: 8,
    width: '100%',
    alignSelf: 'center',
  },

  Main: {
    marginTop: 20,
    paddingHorizontal: 20,
    paddingLeft: 50,
    right: 5,
  },

  DiaDaSemana: {
    fontSize: 20,
    color: '#fff',
    fontFamily: "Nunito-VariableFont_wght",
    marginBottom: 20, 
  },

  //------------------------------------------------------------

  /*Caixa Materia 1*/
  caixaMateria1: {
    backgroundColor: '#fff',
    borderRadius: 10,
    overflow: 'hidden', 
    marginBottom: 20,
    borderColor: 'black',
    borderWidth: 1,
    height: 80, 
    width: 300,

  },

  caixaMateria1Expandida: {
    height: 'auto',

  },

  textoMateria1: {
    fontSize: 22,
    color: '#0073e6',
    marginTop: 10,
    textAlign: 'center',
    fontFamily: 'Nunito-VariableFont_wght',
    right: 15,
  },

  textoHorario1: {
    fontSize: 15,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
    textAlign: 'right',
    paddingRight: 10,
    bottom: 48,
  },

  textoConteudoMinistrado1: {
    fontSize: 14,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
    textAlign: 'center',
    textDecorationLine: 'underline',
    bottom:40,
    left:33,
  },

  ImgLivro: {
    width: 60,
    height: 58,
    marginTop: 10,
    alignSelf: 'flex-start',
    bottom:105,
    left: 10,
  },

  realizarChamada:{
    color: '#FF0000',
    top: 100,
    textDecorationLine: 'underline',
  },

  Salvar:{
    color: '#229A00',
    top: 81,
    left:200,
    textDecorationLine: 'underline',
  },

  /*Separação Materia do Horario - Caixa Materia 1*/
  linha1: {
    height: 23,
    width: 1.5,
    backgroundColor: '#003F98',
    left:200,
    bottom:25,
  },

  /*Conteúdo oculto quando expandido*/
  conteudoOculto: {
    paddingHorizontal: 25,
    marginTop: 10,
    bottom: 100,
  },

  textoConteudoOculto: {
    fontSize: 14,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
  },

  botoesConteudoOculto:{
    fontFamily: 'Nunito-VariableFont_wght',
    fontSize: 14,

  },

  //----------------------------------------------------------------
  /*Caixa Materia 2*/
  caixaMateria2: {
    backgroundColor: '#fff',
    borderRadius: 10,
    overflow: 'hidden', 
    marginBottom: 20,
    borderColor: 'black',
    borderWidth: 1,
    height: 80, 
    width: 300,
  },

  caixaMateria2Expandida: {
    height: 'auto',
  },

  textoMateria2: {
    fontSize: 22,
    color: '#0073e6',
    marginTop: 10,
    textAlign: 'center',
    fontFamily: 'Nunito-VariableFont_wght',
    right: 15,
  },

  textoHorario2: {
    fontSize: 15,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
    textAlign: 'right',
    paddingRight: 10,
    bottom: 48,
  },

  textoConteudoMinistrado2: {
    fontSize: 14,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
    textAlign: 'center',
    textDecorationLine: 'underline',
    bottom:40,
    left:33,
  },

  ImgLampada: {
    width: 60,
    height: 58,
    marginTop: 10,
    alignSelf: 'flex-start',
    bottom:105,
    left: 10,
  },

  /*Separação Materia do Horario - Caixa Materia 2*/
  linha2: {
    height: 23,
    width: 1.5,
    backgroundColor: '#003F98',
    left:200,
    bottom:25,

  },

  /*Conteúdo oculto quando expandido*/
  conteudoOculto2: {
    paddingHorizontal: 25,
    marginTop: 10,
    bottom: 100,
  },

  textoConteudoOculto2: {
    fontSize: 14,
    color: '#0073e6',
    fontFamily: 'Nunito-VariableFont_wght',
  },

  LinhaSeparacaoDiaSemana1:{
    height: 1,
    width: 300,
    marginTop: 0,
    marginBottom: 15,
    backgroundColor: "#fff",

  },
  linha3: {
    height: 23,
    width: 1.5,
    backgroundColor: '#003F98',
    left:193,
    bottom:25,
  },
  linha4: {
    height: 23,
    width: 1.5,
    backgroundColor: '#003F98',
    left:190,
    bottom:25,
  },
});