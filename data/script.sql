-- user: userLambda
-- pswd: datenbankschlussel

-- Table: public.bouees

-- DROP TABLE public.bouees;

CREATE TABLE public.bouees
(
    id bigint NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    numero integer NOT NULL,
    description character varying(100) COLLATE pg_catalog."default" NOT NULL,
    date_debut timestamp(0) without time zone NOT NULL,
    latitude numeric(10,8) NOT NULL,
    longitude numeric(10,8) NOT NULL,
    CONSTRAINT bouees_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.bouees
    OWNER to "postgres";

-- Table: public.donnee_bouees

-- DROP TABLE public.donnee_bouees;

CREATE TABLE public.donnee_bouees
(
    id bigint NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    id_bouee integer NOT NULL,
    temperature numeric(4,2) NOT NULL,
    salinite numeric(4,2) NOT NULL,
    debit numeric(4,2) NOT NULL,
    valide boolean NOT NULL,
    date_temps timestamp(0) without time zone NOT NULL,
    latitude numeric(10,8) NOT NULL,
    longitude numeric(10,8) NOT NULL,
    batterie integer NOT NULL,
    CONSTRAINT donnee_bouees_pkey PRIMARY KEY (id),
    CONSTRAINT donnee_bouees_id_bouee_foreign FOREIGN KEY (id_bouee)
        REFERENCES public.bouees (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.donnee_bouees
    OWNER to "postgres";

