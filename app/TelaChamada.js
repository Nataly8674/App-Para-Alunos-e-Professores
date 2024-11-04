import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Dimensions, Image } from 'react-native';
import LinearGradient from 'react-native-linear-gradient';
import { useNavigation } from '@react-navigation/native';

const { width } = Dimensions.get('window'); 

const AttendanceScreen = () => {
  const navigation = useNavigation();
  const [presenca, setPresenca] = useState({
    aluno1: null,
    aluno2: null,
    aluno3: null,
    aluno4: null,
  });

  const tratarSelecao = (aluno, status) => {
    setPresenca({
      ...presenca,
      [aluno]: status,
    });
  };

  const salvarPresenca = () => {
    console.log('Chamada salva:', presenca);
    // Aqui você pode adicionar a lógica para salvar os dados em um banco de dados
    navigation.navigate("HorarioAulas");
  };

  return (
    <View style={styles.container}>
      
      {/*Header*/}
      <View style={styles.header}>
        <View style={styles.headerContent}>
          <Text style={styles.textoHeader}>Lista de Chamada</Text>
          <TouchableOpacity onPress={() => navigation.navigate("HorarioAulas")}>
            <Image source={require('../app/assets/IMG/seta1.png')} style={[styles.seta]} />
          </TouchableOpacity>
        </View>
      </View>

      {/*Sombra para o Header*/}
      <View style={styles.rectanglesContainer}>
        <LinearGradient 
          colors={['#092d5e', '#2F80ED']} style={styles.retangulo1}/>
      </View>
      
      <View>
      {/* Data fora do container */}
      <Text style={styles.data}>Segunda-Feira 12/08/2024</Text>
      </View>

      {/* Container com informações da matéria e lista de presença, estendido até o fundo da tela */}
      <View style={styles.containerPresenca}>
        <Text style={styles.materia}>Português | 7:45 - 9:30</Text>

        <View style={styles.listaAlunos}>
          {['aluno1', 'aluno2', 'aluno3', 'aluno4'].map((aluno, index) => (
            <View key={index} style={styles.linha}>
              <Text style={styles.nomeAluno}>Aluno {index + 1}</Text>
              <View style={styles.grupoRadio}>
                <TouchableOpacity
                  style={styles.radio}
                  onPress={() => tratarSelecao(aluno, 'P')}>
                  <View style={presenca[aluno] === 'P' ? styles.radioSelecionado : styles.radioNaoSelecionado} />
                  <Text style={styles.labelRadio}>P</Text>
                </TouchableOpacity>

                <TouchableOpacity
                  style={styles.radio}
                  onPress={() => tratarSelecao(aluno, 'F')}>
                  <View style={presenca[aluno] === 'F' ? styles.radioSelecionado : styles.radioNaoSelecionado} />
                  <Text style={styles.labelRadio}>F</Text>
                </TouchableOpacity>
              </View>
            </View>
          ))}
        </View>

        {/* Botão de salvar posicionado no final do container */}
        <TouchableOpacity style={styles.botaoSalvar} onPress={salvarPresenca}>
          <Text style={styles.textoBotaoSalvar}>Salvar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

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
  
  data: {
    fontSize: 20,
    color: '#FFFFFF',
    marginBottom: 20,
    textAlign: 'left',
  },

  containerPresenca: {
    flex: 1, // Estica o container para ocupar todo o espaço disponível
    padding: 20,
    borderRadius: 10,
    backgroundColor: '#ffffff',
    elevation: 2,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.1,
    shadowRadius: 3,
    justifyContent: 'flex-end', // Garante que o botão fique na parte inferior
  },

  materia: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#003366',
    marginBottom: 15,
    textAlign: 'center',
  },

  listaAlunos: {
    flexGrow: 1, // Permite que a lista de alunos ocupe o espaço restante
  },

  linha: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginVertical: 10,
  },

  nomeAluno: {
    fontSize: 16,
    color: '#333',
  },

  grupoRadio: {
    flexDirection: 'row',
  },

  radio: {
    flexDirection: 'row',
    alignItems: 'center',
    marginHorizontal: 10,
  },

  radioNaoSelecionado: {
    width: 20,
    height: 20,
    borderRadius: 10,
    borderWidth: 2,
    borderColor: '#003366',
    marginRight: 5,
  },

  radioSelecionado: {
    width: 20,
    height: 20,
    borderRadius: 10,
    backgroundColor: '#003366',
    marginRight: 5,
  },

  labelRadio: {
    fontSize: 16,
    color: '#333',
  },

  botaoSalvar: {
    backgroundColor: '#003366',
    paddingVertical: 10,
    borderRadius: 5,
    marginTop: 20,
    alignItems: 'center',
  },

  textoBotaoSalvar: {
    color: '#ffffff',
    fontSize: 16,
    fontWeight: 'bold',
  },
});

export default AttendanceScreen;
