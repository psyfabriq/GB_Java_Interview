-- Table: public.visitor

-- DROP TABLE public.visitor;

CREATE TABLE public.visitor
(
    id bigint NOT NULL DEFAULT nextval('visitor_id_seq'::regclass),
    session_id bigint NOT NULL DEFAULT nextval('visitor_session_id_seq'::regclass),
    CONSTRAINT visitor_pkey PRIMARY KEY (id),
    CONSTRAINT session_foreign_key FOREIGN KEY (session_id)
        REFERENCES public.session (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.visitor
    OWNER to postgres;

-- Index: fki_session_foregn_key

-- DROP INDEX public.fki_session_foregn_key;

CREATE INDEX fki_session_foregn_key
    ON public.visitor USING btree
    (session_id)
    TABLESPACE pg_default;
