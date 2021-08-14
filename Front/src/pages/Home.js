import Navbar from '../components/Navbar/index';
import styled from 'styled-components';
import img1 from '../img/1.jpg';
import img2 from '../img/2.jpg';
import img3 from '../img/3.jpg';
import img4 from '../img/4.jpg';
import Footer from '../components/Footer/index';

const Parallax = styled.div `
  width: 100vw;
  height: 100vh;

  .pimg1, .pimg2, .pimg3, .pimg4 {
    opacity: 0.55;
    background-attachment: fixed;
    background-size: cover;
    background-repeat: no-repeat;
    width: 100%;
    height: 87.4%;
  }

  .pimg1 {
    background-image: url(${img1});
  }

  .pimg2 {
    background-image: url(${img2});
  }

  .pimg3 {
    background-image: url(${img3});
  }

  .pimg4 {
    background-image: url(${img4});
  }

  .textHome {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .spanHome {
    position: relative;
    padding: 1%;
    border: 2px solid white;
    background: #8DB892;
    width: 20%;
    border-radius: 20px;
    text-align: center;
    font-weight: bold;
    color: white;
  }

  .spacer {
      width: 100%;
      height: 10%;
      background: #8DB892;
      color: white;
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      align-items: center;
      text-align: center;
      border-top: 2px solid white;
      border-bottom: 2px solid white;
      font-weight: bold;
      font-size: 
  }
`;

function Home() {
  return (
    <>
      <Navbar />
      <Parallax>
        {/* DIV 1 */}
        <div className="pimg1">
          <div className="textHome">
            <div className="spanHome">
              <span>CONTROLE FINANCEIRO EFICIENTE</span>
            </div>
          </div>
        </div>
        <div className="spacer">
          <p>Acreditamos que um controle financeiro pode ser <strong>eficiente</strong> e ao mesmo tempo <strong>simples</strong>. Aqui no FinanC você poderá verificar isso na prática, enquanto equilibra suas contas e melhora substancialmente sua saúde financeira.</p>
        </div>
        {/* FIM DIV 1 */}

        {/* DIV 2 */}
        <div className="pimg2">
          <div className="textHome">
            <div className="spanHome">
              <span>TRACE METAS</span>
            </div>
          </div>
        </div>
        <div className="spacer">
          <p>Vamos mais longe quando temos disciplina. Ao controlar suas finanças, você terá a oportunidade de traçar metas mais arrojadas, sejam elas de curto, médio ou longo prazo.</p>
        </div>
        {/* FIM DIV 2 */}

        {/* DIV 3 */}
        <div className="pimg3">
          <div className="textHome">
            <div className="spanHome">
              <span>IMPULSIONE SEUS SONHOS</span>
            </div>
          </div>
        </div>
        <div className="spacer">
          <p>Qual o seu sonho? Uma viagem, um imóvel, abrir seu próprio negócio? Tendo metas estabelecidas, você fica mais perto de realizar seus sonhos.</p>
        </div>
        {/* FIM DIV 3 */}

        {/* DIV 4 */}
        <div className="pimg4">
          <div className="textHome">
            <div className="spanHome">
              <span>ORGANIZE SUAS FINANÇAS</span>
            </div>
          </div>
        </div>
        {/* FIM DIV 4 */}
      </Parallax>
      <Footer />
    </>
  );
}

export default Home;