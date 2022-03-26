import Head from 'next/head'
import FormCliente from '../components/FormCliente'
import FormUser from '../components/FormUser'
import styles from '../styles/Home.module.css'

export default function Home() {
  return (
    <div className={styles.container}>
      <Head>
        <title>Create Next App</title>
        <meta name="description" content="Generated by create next app" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <div><h1>Tela inicial</h1></div>
      <FormUser nomeform="FORMULARIO CADASTRO DE CLIENTES" />
      <FormCliente />
    </div>
  )
}