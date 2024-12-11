def tabela_multiplicacao_recursiva(array, index=0):
    # Caso base: se o índice atingir o final do array, encerra a recursão
    if index == len(array):
        return

    # Multiplicador atual
    multiplicador = array[index]

    # Função interna para realizar a multiplicação com cada elemento do array
    def multiplicar_com_elementos(array, multiplicador, inner_index=0):
        # Caso base interno: se o índice interno atingir o final do array, encerra
        if inner_index == len(array):
            return

        # Calcula e imprime o resultado
        elemento = array[inner_index]
        print(f"{multiplicador} x {elemento} = {multiplicador * elemento}")

        # Chama recursivamente para o próximo elemento
        multiplicar_com_elementos(array, multiplicador, inner_index + 1)

    # Imprime a tabela para o multiplicador atual
    print(f"\nMultiplicando por {multiplicador}:")
    multiplicar_com_elementos(array, multiplicador)

    # Chama recursivamente para o próximo multiplicador
    tabela_multiplicacao_recursiva(array, index + 1)

# Exemplo de uso
array = [2, 3, 7, 8, 10]
tabela_multiplicacao_recursiva(array)
