function copy(){navigator.clipboard.writeText("gabrielhenriquegemelli@gmail.com")}
function exibirAlerta(){copy();document.getElementById('alerta').style.display='block';document.getElementById('overlay').style.display='block';document.body.style.overflow='hidden'}
function fecharAlerta(){document.getElementById('alerta').style.display='none';document.getElementById('overlay').style.display='none';document.body.style.overflow='auto'}
document.addEventListener('keydown',e=>{if(e.key==='Escape') fecharAlerta()})

const CERTS=[
  {name:'AWS Certified Cloud Practitioner',issuer:'AWS',year:'2025',url:''},
  {name:'Java Fundamentals',issuer:'Oracle/Alura',year:'2024',url:''}
];

const i18n={
  pt:{
    doc_title:'Portfólio • Gabriel Henrique Gemelli',
    subtitle_pt:'Desenvolvedor em formação • Back-end',
    location_pt:'Passo Fundo, RS • Português/English',
    chip_copy:'Copiar e-mail',
    chip_whatsapp:'WhatsApp',
    chip_github:'GitHub',
    chip_cv:'Baixar CV',
    about_title:'Sobre mim',
    about_body_pt:'Sou apaixonado por computação, focado em programação e raciocínio lógico. Curso Ciência da Computação na <strong>ATITUS</strong> e sigo determinado a me tornar um desenvolvedor back-end. Comecei estudando online e hoje avanço com projetos práticos na faculdade e fora dela.',
    goal_title:'Objetivo',
    goal_list_pt:'<li>Tornar-me um desenvolvedor <strong>back-end</strong> sólido, entregando APIs escaláveis e bem testadas.</li><li>Concluir a graduação com alta performance acadêmica.</li><li>Contribuir em projetos que ajudem pessoas em escala.</li>',
    xp_title:'Experiência Profissional',
    xp_compass_role:'<strong>Estagiário de Desenvolvimento Back-end (AWS)</strong> • Compass UOL',
    xp_compass_list_pt:'<li>Atuação no desenvolvimento de serviços back-end utilizando AWS.</li><li>Implementação de endpoints e rotinas server-side com foco em qualidade e boas práticas.</li><li>Colaboração em revisão de código e rotinas de versionamento com Git/GitHub.</li>',
    xp_inotek_role:'<strong>Desenvolvedor Full-Stack</strong> • Inotek',
    xp_inotek_date:'mai/2023 — atual',
    xp_inotek_list_pt:'<li>Desenvolvimento de aplicações web com Angular.</li><li>Foco em melhorar a experiência em dispositivos Android.</li><li>Apoio à manutenção do produto principal.</li>',
    langs_title:'Idiomas',
    langs_list_pt:'<li>Português — Nativo</li><li>Inglês — Fluente</li>',
    edu_title:'Educação',
    edu_list_pt:'<li><strong>ATITUS Educação</strong> — Ciência da Computação</li><li><strong>Escola Scalabrini</strong> — Ensino Médio</li><li><strong>Escola Conceição</strong> — Ensino Fundamental</li>',
    tech_title:'Tecnologias',
    projects_title:'Projetos em destaque',
    projects_list_pt:'',
    certs_title:'Certificados',
    certs_empty:'Nenhum certificado adicionado ainda.',
    cert_view:'ver',
    footer_email:'E-mail',
    footer_github:'GitHub',
    alert_title:'Pronto!',
    alert_msg:'E-mail copiado com sucesso.',
    alert_ok:'OK'
  },
  en:{
    doc_title:'Portfolio • Gabriel Henrique Gemelli',
    subtitle_pt:'Developer in training • Back-end',
    location_pt:'Passo Fundo, Brazil • Portuguese/English',
    chip_copy:'Copy email',
    chip_whatsapp:'WhatsApp',
    chip_github:'GitHub',
    chip_cv:'Download CV',
    about_title:'About',
    about_body_pt:'I am passionate about CS, focused on programming and logical thinking. I study Computer Science at <strong>ATITUS</strong> and I’m determined to become a back-end developer. I started online and now keep progressing with practical projects.',
    goal_title:'Goal',
    goal_list_pt:'<li>Become a solid <strong>back-end</strong> developer, delivering scalable and well-tested APIs.</li><li>Graduate with strong academic performance.</li><li>Contribute to projects that help people at scale.</li>',
    xp_title:'Experience',
    xp_compass_role:'<strong>Back-end Development Intern (AWS)</strong> • Compass UOL',
    xp_compass_list_pt:'<li>Worked on back-end services using AWS.</li><li>Implemented endpoints and server-side routines emphasizing quality and best practices.</li><li>Collaborated on code reviews and version control with Git/GitHub.</li>',
    xp_inotek_role:'<strong>Full-Stack Developer</strong> • Inotek',
    xp_inotek_date:'May/2023 — present',
    xp_inotek_list_pt:'<li>Web app development with Angular.</li><li>Improving UX on Android devices.</li><li>Support maintaining the main product.</li>',
    langs_title:'Languages',
    langs_list_pt:'<li>Portuguese — Native</li><li>English — Fluent</li>',
    edu_title:'Education',
    edu_list_pt:'<li><strong>ATITUS Education</strong> — Computer Science</li><li><strong>Escola Scalabrini</strong> — High School</li><li><strong>Escola Conceição</strong> — Elementary School</li>',
    tech_title:'Technologies',
    projects_title:'Featured projects',
    projects_list_pt:'',
    certs_title:'Certificates',
    certs_empty:'No certificates added yet.',
    cert_view:'view',
    footer_email:'Email',
    footer_github:'GitHub',
    alert_title:'Done!',
    alert_msg:'Email copied successfully.',
    alert_ok:'OK'
  }
};

function renderCerts(lang){
  const dict=i18n[lang];
  const ul=document.getElementById('cert-list');
  const empty=document.getElementById('cert-empty');
  if(!ul||!empty) return;
  if(!CERTS.length){
    ul.innerHTML='';empty.style.display='block';empty.innerHTML=dict.certs_empty;return;
  }
  empty.style.display='none';
  ul.innerHTML=CERTS.map(c=>{
    const link=c.url?` — <a href="${c.url}" target="_blank" rel="noopener">${dict.cert_view}</a>`:'';
    const issuer=c.issuer?` — ${c.issuer}`:'';
    const year=c.year?` (${c.year})`:'';
    return `<li><strong>${c.name}</strong>${issuer}${year}${link}</li>`;
  }).join('');
}

function setLang(lang){
  const root=document.documentElement;
  root.lang=lang==='pt'?'pt-BR':'en';
  const dict=i18n[lang];
  document.querySelectorAll('[data-i18n]').forEach(el=>{
    const key=el.getAttribute('data-i18n');if(!dict[key]) return;el.innerHTML=dict[key];
  });
  document.title=dict.doc_title||document.title;
  document.querySelectorAll('[data-set-lang]').forEach(a=>{
    a.classList.toggle('active',a.getAttribute('data-set-lang')===lang);
  });
  localStorage.setItem('lang',lang);
  renderCerts(lang);
}

document.addEventListener('DOMContentLoaded',()=>{
  const y=document.getElementById('year');if(y) y.textContent=new Date().getFullYear();
  const saved=localStorage.getItem('lang')||'pt';setLang(saved);
  document.querySelectorAll('[data-set-lang]').forEach(a=>{
    a.addEventListener('click',e=>{e.preventDefault();setLang(a.getAttribute('data-set-lang'));});
  });
});
