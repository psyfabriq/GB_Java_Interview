-- Table: public.films

-- DROP TABLE public.films;

CREATE TABLE public.films
(
    title character varying(150) COLLATE pg_catalog."default" NOT NULL,
    duration_id bigint NOT NULL DEFAULT nextval('films_duration_id_seq'::regclass),
    id bigint NOT NULL DEFAULT nextval('films_id_seq'::regclass),
    description text COLLATE pg_catalog."default",
    CONSTRAINT films_pkey PRIMARY KEY (id),
    CONSTRAINT "films_ID_key" UNIQUE (id)
,
    CONSTRAINT duration_foreign_key FOREIGN KEY (duration_id)
        REFERENCES public.duration (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.films
    OWNER to postgres;

-- Index: fki_duration_foreign_key

-- DROP INDEX public.fki_duration_foreign_key;

CREATE INDEX fki_duration_foreign_key
    ON public.films USING btree
    (duration_id)
    TABLESPACE pg_default;
