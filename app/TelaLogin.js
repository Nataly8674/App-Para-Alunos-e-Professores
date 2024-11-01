import { useNavigation } from '@react-navigation/native';
import React, { useState } from 'react';
import { StyleSheet, Text, View, TextInput, TouchableOpacity, Image, Dimensions, ViewComponent } from 'react-native';

const { width } = Dimensions.get('window');

export function TelaLogin() {
  const [isFocused, setIsFocused] = useState(false);
  const navigation = useNavigation();
  const [isPressed, setIsPressed] = useState(false);

  const handleFocus = () => setIsFocused(true);
  const handleBlur = () => setIsFocused(false);

  const handlePressIn = () => setIsPressed(true);
  const handlePressOut = () => setIsPressed(false);

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Image source={require('../app/assets/IMG/RecorteLogo2.png')} style={styles.headerImage} />
      </View>
      <View style={styles.rectanglesContainer}>
        <View style={styles.retangulo1} />
        <View style={styles.retangulo2} />
        <View style={styles.retangulo3} />
      </View>
      <View style={styles.imagesContainer}>
        <Image source={require('../app/assets/IMG/logoOk-removebg-preview.png')} style={styles.image1} />
        <Image source={require('../app/assets/IMG/Captura_de_tela_2024-10-11_011645-removebg-preview.png')} style={styles.image2} />
      </View>
      <View style={[styles.loginContainer, isFocused && styles.loginContainerFocused]}>
        <Text style={styles.loginText}>Login</Text>
        <TextInput
          style={styles.input}
          placeholder="CPF"
          placeholderTextColor="#666"
          keyboardType="numeric"
          onFocus={handleFocus}
          onBlur={handleBlur}
        />
        <TextInput
          style={styles.input}
          placeholder="Senha"
          secureTextEntry={true}
          placeholderTextColor="#666"
          onFocus={handleFocus}
          onBlur={handleBlur}
        />
        <View style={styles.forgotPasswordContainer}>
          <TouchableOpacity>
            <Text style={styles.forgotPassword}>Esqueceu a senha?</Text>
          </TouchableOpacity>
        </View>

        <Image source={require('../app/assets/IMG/onda1.png')} style={styles.ondaImage} />        

        <TouchableOpacity onPress={()=>navigation.navigate("PainelInicial")}
          style={[styles.loginButton, isPressed && styles.loginButtonPressed]}
          onPressIn={handlePressIn}
          onPressOut={handlePressOut}
        >
          <Text style={[styles.loginButtonText, isPressed && styles.loginButtonTextPressed]}>Login</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },

  header: {
    position: 'absolute',
    top: 0,
    flexDirection: 'row',
    backgroundColor: '#0073e6',
    width: width,
    height: 50,
    alignItems: 'center',
    justifyContent: 'flex-end',
    paddingHorizontal: 16,
  },

  headerImage: {
    width: 80,
    height: 30,
  },

  rectanglesContainer: {
    position: 'absolute',
    top: 50,
    flexDirection: 'row',
    width: width,
  },

  retangulo1: {
    backgroundColor: '#003F98',
    height: 5,
    width: '33.7%',
  },

  retangulo2: {
    backgroundColor: '#7BB52B',
    height: 5,
    width: '33.7%',
  },

  retangulo3: {
    backgroundColor: '#FFB400',
    height: 5,
    width: '33.7%',
  },

  imagesContainer: {
    flexDirection: 'row',
    top: 120,
    width: '87%',
    position: 'absolute',
  },

  image1: {
    width: 400,
    height: 200,
    resizeMode: 'contain',
    alignSelf: 'flex-start',
  },

  image2: {
    width: 500,
    height: 170,
    resizeMode: 'contain',
    position: 'absolute',
    right: 30,
  },

  loginContainer: {
    width: '96%',
    padding: 20,
    marginTop: 200,
  },

  loginContainerFocused: {
    backgroundColor: '#fff',
    borderRadius: 10,
  },

  loginText: {
    fontSize: 30,
    fontWeight: 'bold',
    color: '#0073e6',
    marginBottom: 20,
    textAlign: 'left',
  },

  input: {
    width: '100%',
    height: 40,
    borderColor: '#0073e6',
    borderWidth: 1,
    borderRadius: 10,
    marginBottom: 10,
    paddingLeft: 10,
  },

  forgotPasswordContainer: {
    width: '100%',
    flexDirection: 'row',
    justifyContent: 'flex-end',
    marginBottom: 20,
  },

  forgotPassword: {
    color: '#0073e6',
  },

  ondaImage: {
    width: 460,
    height: 200,
    position: 'absolute',
    top: 220,
    right: -10,
  },

  loginButton: {
    position: 'absolute',
    top: 300, 
    left: '70%', 
    width: 120,
    height: 50,
    backgroundColor: 'transparent',
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: 7,
    borderColor: '#fff',
    borderWidth: 1,
    elevation: 20,      // Efeito de sombra para Android, limitado comparado com o do IOS           
  },                    // uma linhazinha veia podi não gostei muito do resultado
                        // vou ver se vou manter
  loginButtonPressed: {
    backgroundColor: '#fff',
  },

  loginButtonText: {
    color: '#fff',
    fontSize: 20,
  },

  loginButtonTextPressed: {
    color: '#0073e6',
  },
});