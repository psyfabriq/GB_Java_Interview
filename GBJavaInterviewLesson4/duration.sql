-- Table: public.duration

-- DROP TABLE public.duration;

CREATE TABLE public.duration
(
    id bigint NOT NULL DEFAULT nextval('duration_id_seq'::regclass),
    duration interval,
    CONSTRAINT duration_pkey PRIMARY KEY (id),
    CONSTRAINT "duration_ID_key" UNIQUE (id)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.duration
    OWNER to postgres;
