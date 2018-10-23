-- Table: public.session

-- DROP TABLE public.session;

CREATE TABLE public.session
(
    id bigint NOT NULL DEFAULT nextval('"session_ID_seq"'::regclass),
    film_id bigint NOT NULL,
    cost money NOT NULL,
    ts_start timestamp without time zone,
    ts_stop timestamp without time zone,
    interval_id bigint DEFAULT nextval('"session_INTERVAL_ID_seq"'::regclass),
    CONSTRAINT session_pkey PRIMARY KEY (id)
        INCLUDE(id),
    CONSTRAINT "session_ID_key" UNIQUE (id)
,
    CONSTRAINT session_ts_start_key UNIQUE (ts_start)
,
    CONSTRAINT film_foreign_key FOREIGN KEY (film_id)
        REFERENCES public.films (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT interval_foreign_key FOREIGN KEY (interval_id)
        REFERENCES public.duration (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.session
    OWNER to postgres;

-- Index: fki_film_foreign_key

-- DROP INDEX public.fki_film_foreign_key;

CREATE INDEX fki_film_foreign_key
    ON public.session USING btree
    (film_id)
    TABLESPACE pg_default;

-- Index: fki_interval_foreign_key

-- DROP INDEX public.fki_interval_foreign_key;

CREATE INDEX fki_interval_foreign_key
    ON public.session USING btree
    (interval_id)
    TABLESPACE pg_default;

-- Trigger: set_timestamp_stop

-- DROP TRIGGER set_timestamp_stop ON public.session;

CREATE TRIGGER set_timestamp_stop
    BEFORE INSERT OR UPDATE
    ON public.session
    FOR EACH ROW
    EXECUTE PROCEDURE public.trigger_set_timestamp_stop();
