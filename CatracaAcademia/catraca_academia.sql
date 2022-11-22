--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2022-11-22 12:50:59

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 24825)
-- Name: alunos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alunos (
    codigo integer NOT NULL,
    nome text NOT NULL,
    cpf text NOT NULL,
    data_nascimento date NOT NULL,
    contato text NOT NULL,
    id_cidade integer NOT NULL
);


ALTER TABLE public.alunos OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24824)
-- Name: alunos_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alunos_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alunos_codigo_seq OWNER TO postgres;

--
-- TOC entry 3420 (class 0 OID 0)
-- Dependencies: 215
-- Name: alunos_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alunos_codigo_seq OWNED BY public.alunos.codigo;


--
-- TOC entry 229 (class 1259 OID 24936)
-- Name: assiduidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.assiduidade (
    codigo integer NOT NULL,
    data date NOT NULL,
    id_matricula integer NOT NULL
);


ALTER TABLE public.assiduidade OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 24935)
-- Name: assiduidade_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.assiduidade_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.assiduidade_codigo_seq OWNER TO postgres;

--
-- TOC entry 3421 (class 0 OID 0)
-- Dependencies: 228
-- Name: assiduidade_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.assiduidade_codigo_seq OWNED BY public.assiduidade.codigo;


--
-- TOC entry 214 (class 1259 OID 24811)
-- Name: cidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cidades (
    codigo integer NOT NULL,
    nome text NOT NULL,
    id_estado integer NOT NULL
);


ALTER TABLE public.cidades OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 24810)
-- Name: cidades_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cidades_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cidades_codigo_seq OWNER TO postgres;

--
-- TOC entry 3422 (class 0 OID 0)
-- Dependencies: 213
-- Name: cidades_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cidades_codigo_seq OWNED BY public.cidades.codigo;


--
-- TOC entry 212 (class 1259 OID 24797)
-- Name: estados; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estados (
    codigo integer NOT NULL,
    nome text NOT NULL,
    uf text NOT NULL,
    id_pais integer NOT NULL
);


ALTER TABLE public.estados OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24796)
-- Name: estados_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estados_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estados_codigo_seq OWNER TO postgres;

--
-- TOC entry 3423 (class 0 OID 0)
-- Dependencies: 211
-- Name: estados_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estados_codigo_seq OWNED BY public.estados.codigo;


--
-- TOC entry 220 (class 1259 OID 24851)
-- Name: faturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.faturas (
    codigo integer NOT NULL,
    id_matricula integer NOT NULL,
    data_vencimento date NOT NULL,
    data_pagamento date,
    valor numeric(9,2) NOT NULL
);


ALTER TABLE public.faturas OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24850)
-- Name: faturas_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.faturas_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.faturas_codigo_seq OWNER TO postgres;

--
-- TOC entry 3424 (class 0 OID 0)
-- Dependencies: 219
-- Name: faturas_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.faturas_codigo_seq OWNED BY public.faturas.codigo;


--
-- TOC entry 224 (class 1259 OID 24886)
-- Name: graduacoes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.graduacoes (
    codigo integer NOT NULL,
    nome text NOT NULL,
    id_modalidade integer NOT NULL
);


ALTER TABLE public.graduacoes OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 24885)
-- Name: graduacoes_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.graduacoes_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.graduacoes_codigo_seq OWNER TO postgres;

--
-- TOC entry 3425 (class 0 OID 0)
-- Dependencies: 223
-- Name: graduacoes_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.graduacoes_codigo_seq OWNED BY public.graduacoes.codigo;


--
-- TOC entry 218 (class 1259 OID 24839)
-- Name: matriculas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matriculas (
    codigo integer NOT NULL,
    id_aluno integer NOT NULL,
    data_matricula date NOT NULL,
    data_encerramento date
);


ALTER TABLE public.matriculas OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24838)
-- Name: matriculas_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.matriculas_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.matriculas_codigo_seq OWNER TO postgres;

--
-- TOC entry 3426 (class 0 OID 0)
-- Dependencies: 217
-- Name: matriculas_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.matriculas_codigo_seq OWNED BY public.matriculas.codigo;


--
-- TOC entry 227 (class 1259 OID 24920)
-- Name: matriculas_planos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matriculas_planos (
    codigo_matricula integer NOT NULL,
    codigo_plano integer NOT NULL,
    data_inicio date NOT NULL
);


ALTER TABLE public.matriculas_planos OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24863)
-- Name: modalidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modalidades (
    codigo integer NOT NULL,
    nome text NOT NULL
);


ALTER TABLE public.modalidades OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24862)
-- Name: modalidades_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modalidades_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modalidades_codigo_seq OWNER TO postgres;

--
-- TOC entry 3427 (class 0 OID 0)
-- Dependencies: 221
-- Name: modalidades_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modalidades_codigo_seq OWNED BY public.modalidades.codigo;


--
-- TOC entry 210 (class 1259 OID 24788)
-- Name: paises; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paises (
    codigo integer NOT NULL,
    nome text NOT NULL
);


ALTER TABLE public.paises OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24787)
-- Name: paises_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paises_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.paises_codigo_seq OWNER TO postgres;

--
-- TOC entry 3428 (class 0 OID 0)
-- Dependencies: 209
-- Name: paises_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paises_codigo_seq OWNED BY public.paises.codigo;


--
-- TOC entry 226 (class 1259 OID 24900)
-- Name: planos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.planos (
    codigo integer NOT NULL,
    descricao text NOT NULL,
    id_graduacao integer NOT NULL,
    valor_mensal numeric(9,2) NOT NULL
);


ALTER TABLE public.planos OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 24899)
-- Name: planos_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.planos_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.planos_codigo_seq OWNER TO postgres;

--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 225
-- Name: planos_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.planos_codigo_seq OWNED BY public.planos.codigo;


--
-- TOC entry 3216 (class 2604 OID 24828)
-- Name: alunos codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alunos ALTER COLUMN codigo SET DEFAULT nextval('public.alunos_codigo_seq'::regclass);


--
-- TOC entry 3222 (class 2604 OID 24939)
-- Name: assiduidade codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assiduidade ALTER COLUMN codigo SET DEFAULT nextval('public.assiduidade_codigo_seq'::regclass);


--
-- TOC entry 3215 (class 2604 OID 24814)
-- Name: cidades codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidades ALTER COLUMN codigo SET DEFAULT nextval('public.cidades_codigo_seq'::regclass);


--
-- TOC entry 3214 (class 2604 OID 24800)
-- Name: estados codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados ALTER COLUMN codigo SET DEFAULT nextval('public.estados_codigo_seq'::regclass);


--
-- TOC entry 3218 (class 2604 OID 24854)
-- Name: faturas codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faturas ALTER COLUMN codigo SET DEFAULT nextval('public.faturas_codigo_seq'::regclass);


--
-- TOC entry 3220 (class 2604 OID 24889)
-- Name: graduacoes codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.graduacoes ALTER COLUMN codigo SET DEFAULT nextval('public.graduacoes_codigo_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 24842)
-- Name: matriculas codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas ALTER COLUMN codigo SET DEFAULT nextval('public.matriculas_codigo_seq'::regclass);


--
-- TOC entry 3219 (class 2604 OID 24866)
-- Name: modalidades codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalidades ALTER COLUMN codigo SET DEFAULT nextval('public.modalidades_codigo_seq'::regclass);


--
-- TOC entry 3213 (class 2604 OID 24791)
-- Name: paises codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paises ALTER COLUMN codigo SET DEFAULT nextval('public.paises_codigo_seq'::regclass);


--
-- TOC entry 3221 (class 2604 OID 24903)
-- Name: planos codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.planos ALTER COLUMN codigo SET DEFAULT nextval('public.planos_codigo_seq'::regclass);


--
-- TOC entry 3401 (class 0 OID 24825)
-- Dependencies: 216
-- Data for Name: alunos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alunos (codigo, nome, cpf, data_nascimento, contato, id_cidade) FROM stdin;
1	Jhonata Amboni	468.034.880-12	1992-06-01	(48)94002-8922	1
2	Augusto Bressan	894.228.590-26	2001-10-11	(48)99123-5847	1
\.


--
-- TOC entry 3414 (class 0 OID 24936)
-- Dependencies: 229
-- Data for Name: assiduidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.assiduidade (codigo, data, id_matricula) FROM stdin;
1	2022-11-10	3
2	2022-11-11	3
3	2022-11-12	3
\.


--
-- TOC entry 3399 (class 0 OID 24811)
-- Dependencies: 214
-- Data for Name: cidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cidades (codigo, nome, id_estado) FROM stdin;
1	Criciuma	1
2	Florianópolis	1
\.


--
-- TOC entry 3397 (class 0 OID 24797)
-- Dependencies: 212
-- Data for Name: estados; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estados (codigo, nome, uf, id_pais) FROM stdin;
1	Santa Catarina	SC	1
2	Rio Grande Do Sul	RS	1
\.


--
-- TOC entry 3405 (class 0 OID 24851)
-- Dependencies: 220
-- Data for Name: faturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.faturas (codigo, id_matricula, data_vencimento, data_pagamento, valor) FROM stdin;
16	5	2022-12-10	\N	200.00
17	5	2023-01-10	\N	200.00
15	3	2022-12-23	\N	250.00
14	3	2022-11-10	\N	250.00
\.


--
-- TOC entry 3409 (class 0 OID 24886)
-- Dependencies: 224
-- Data for Name: graduacoes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.graduacoes (codigo, nome, id_modalidade) FROM stdin;
1	Faixa preta	3
2	Faixa Amarela	3
3	Faixa preta	4
4	Faixa Amarela	4
\.


--
-- TOC entry 3403 (class 0 OID 24839)
-- Dependencies: 218
-- Data for Name: matriculas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matriculas (codigo, id_aluno, data_matricula, data_encerramento) FROM stdin;
3	1	2022-11-20	\N
5	2	2022-12-01	\N
\.


--
-- TOC entry 3412 (class 0 OID 24920)
-- Dependencies: 227
-- Data for Name: matriculas_planos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matriculas_planos (codigo_matricula, codigo_plano, data_inicio) FROM stdin;
3	1	2022-11-01
3	2	2022-12-01
5	3	2022-12-01
\.


--
-- TOC entry 3407 (class 0 OID 24863)
-- Dependencies: 222
-- Data for Name: modalidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.modalidades (codigo, nome) FROM stdin;
3	Karatê
4	Judo
\.


--
-- TOC entry 3395 (class 0 OID 24788)
-- Dependencies: 210
-- Data for Name: paises; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paises (codigo, nome) FROM stdin;
1	brasil
2	argentina
\.


--
-- TOC entry 3411 (class 0 OID 24900)
-- Dependencies: 226
-- Data for Name: planos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.planos (codigo, descricao, id_graduacao, valor_mensal) FROM stdin;
1	2X Por semana	1	100.00
2	2X Por semana	2	150.00
3	2X Por semana	3	200.00
4	2X Por semana	4	250.00
\.


--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 215
-- Name: alunos_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alunos_codigo_seq', 2, true);


--
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 228
-- Name: assiduidade_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.assiduidade_codigo_seq', 3, true);


--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 213
-- Name: cidades_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cidades_codigo_seq', 2, true);


--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 211
-- Name: estados_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estados_codigo_seq', 2, true);


--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 219
-- Name: faturas_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.faturas_codigo_seq', 17, true);


--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 223
-- Name: graduacoes_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.graduacoes_codigo_seq', 4, true);


--
-- TOC entry 3436 (class 0 OID 0)
-- Dependencies: 217
-- Name: matriculas_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.matriculas_codigo_seq', 5, true);


--
-- TOC entry 3437 (class 0 OID 0)
-- Dependencies: 221
-- Name: modalidades_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modalidades_codigo_seq', 4, true);


--
-- TOC entry 3438 (class 0 OID 0)
-- Dependencies: 209
-- Name: paises_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.paises_codigo_seq', 2, true);


--
-- TOC entry 3439 (class 0 OID 0)
-- Dependencies: 225
-- Name: planos_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.planos_codigo_seq', 4, true);


--
-- TOC entry 3230 (class 2606 OID 24832)
-- Name: alunos alunos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT alunos_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3244 (class 2606 OID 24941)
-- Name: assiduidade assiduidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assiduidade
    ADD CONSTRAINT assiduidade_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3228 (class 2606 OID 24818)
-- Name: cidades cidades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidades
    ADD CONSTRAINT cidades_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3226 (class 2606 OID 24804)
-- Name: estados estados_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados
    ADD CONSTRAINT estados_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3234 (class 2606 OID 24856)
-- Name: faturas faturas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faturas
    ADD CONSTRAINT faturas_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3238 (class 2606 OID 24893)
-- Name: graduacoes graduacoes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.graduacoes
    ADD CONSTRAINT graduacoes_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3232 (class 2606 OID 24844)
-- Name: matriculas matriculas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT matriculas_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3242 (class 2606 OID 24950)
-- Name: matriculas_planos matriculas_planos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_planos
    ADD CONSTRAINT matriculas_planos_pkey PRIMARY KEY (codigo_matricula, codigo_plano);


--
-- TOC entry 3236 (class 2606 OID 24870)
-- Name: modalidades modalidades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalidades
    ADD CONSTRAINT modalidades_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3224 (class 2606 OID 24795)
-- Name: paises paises_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paises
    ADD CONSTRAINT paises_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3240 (class 2606 OID 24907)
-- Name: planos planos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.planos
    ADD CONSTRAINT planos_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3247 (class 2606 OID 24833)
-- Name: alunos fk_alunos_cidades; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT fk_alunos_cidades FOREIGN KEY (id_cidade) REFERENCES public.cidades(codigo);


--
-- TOC entry 3254 (class 2606 OID 24942)
-- Name: assiduidade fk_assiduidade_matriculas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assiduidade
    ADD CONSTRAINT fk_assiduidade_matriculas FOREIGN KEY (id_matricula) REFERENCES public.matriculas(codigo);


--
-- TOC entry 3246 (class 2606 OID 24819)
-- Name: cidades fk_cidades_estados; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidades
    ADD CONSTRAINT fk_cidades_estados FOREIGN KEY (id_estado) REFERENCES public.estados(codigo);


--
-- TOC entry 3245 (class 2606 OID 24805)
-- Name: estados fk_estados_paises; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estados
    ADD CONSTRAINT fk_estados_paises FOREIGN KEY (id_pais) REFERENCES public.paises(codigo);


--
-- TOC entry 3250 (class 2606 OID 24894)
-- Name: graduacoes fk_graduacoes_modalidades; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.graduacoes
    ADD CONSTRAINT fk_graduacoes_modalidades FOREIGN KEY (id_modalidade) REFERENCES public.modalidades(codigo);


--
-- TOC entry 3248 (class 2606 OID 24845)
-- Name: matriculas fk_matriculas_alunos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT fk_matriculas_alunos FOREIGN KEY (id_aluno) REFERENCES public.alunos(codigo);


--
-- TOC entry 3252 (class 2606 OID 24925)
-- Name: matriculas_planos fk_matriculas_planos_matriculas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_planos
    ADD CONSTRAINT fk_matriculas_planos_matriculas FOREIGN KEY (codigo_matricula) REFERENCES public.matriculas(codigo);


--
-- TOC entry 3253 (class 2606 OID 24930)
-- Name: matriculas_planos fk_matriculas_planos_planos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_planos
    ADD CONSTRAINT fk_matriculas_planos_planos FOREIGN KEY (codigo_plano) REFERENCES public.planos(codigo) NOT VALID;


--
-- TOC entry 3251 (class 2606 OID 24908)
-- Name: planos fk_planos_graduacoes; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.planos
    ADD CONSTRAINT fk_planos_graduacoes FOREIGN KEY (id_graduacao) REFERENCES public.graduacoes(codigo);


--
-- TOC entry 3249 (class 2606 OID 24857)
-- Name: faturas fk_planos_matriculas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faturas
    ADD CONSTRAINT fk_planos_matriculas FOREIGN KEY (id_matricula) REFERENCES public.matriculas(codigo);


-- Completed on 2022-11-22 12:50:59

--
-- PostgreSQL database dump complete
--

