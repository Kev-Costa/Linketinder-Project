const path = require('path');

module.exports = {
    entry: {
        login: './src/views/LoginView.ts',
        candidato: './src/views/CandidatoView.ts',
        empresa: './src/views/EmpresaView.ts',
        cadCand: './src/views/CadastroCandidatoView.ts',
        cadEmp: './src/views/CadastroEmpresaView.ts'
    },
    output: {
        filename: '[name]-bundle.js',
        path: path.resolve(__dirname, 'dist'),
    },
    resolve: {
        extensions: ['.ts', '.js'],
    },
    module: {
        rules: [
            {
                test: /\.ts$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
        ],
    },
    devServer: {
        static: {
            directory: path.join(__dirname, './'), // Mantém a raiz visível para carregar os HTMLs e a pasta dist
        },
        compress: true,
        port: 9000,
        hot: true,
        open: ['login.html'], // Abre direto na tela de login automaticamente
    },
};