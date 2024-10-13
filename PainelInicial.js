// PainelInicial.js
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default function PainelInicial() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Bem-vindo ao Painel Inicial!</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#fff',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
  },
});
