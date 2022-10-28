DROP TABLE IF EXISTS client, component, drug, manufacturer, orderr, requestcomponent, technologybook, roles, keys;
DROP TYPE IF EXISTS extemporalmethod, status, orderstatus, releaseform, use, userRole;

CREATE TYPE releaseform AS ENUM ('TABLETS', 'OINTMENT', 'POTION', 'AQUA', 'FLOUR', 'TINCTURE');
CREATE TYPE status AS ENUM ('INPROGRESS', 'GOTTEN');
CREATE TYPE orderstatus AS ENUM ('INPROGRESS', 'GONE', 'PENDING');
CREATE TYPE use AS ENUM ('INTERNAL', 'EXTERNAL', 'INTERNALEXTERNAL', 'MIX');
CREATE TYPE extemporalmethod AS ENUM ('DISSOLVING', 'SWELLING', 'HEATING', 'DILUTION', 'FILTERING', 'EMULSIFYING', 'DISPERSING', 'MIXING');


CREATE TABLE client
(
    id SERIAL PRIMARY KEY,
    createdat timestamp default now() NOT NULL,
    updatedat timestamp default now() NOT NULL,
    description CHARACTER VARYING(30) NOT NULL,

    clientname CHARACTER VARYING(60) NOT NULL,
    clientphnum CHARACTER VARYING(30),
    clientemail CHARACTER VARYING(40),
    clientdatebirth timestamp NOT NULL
);

CREATE TABLE manufacturer
(
    id SERIAL PRIMARY KEY,
    createdat timestamp default now() NOT NULL,
    updatedat timestamp default now() NOT NULL,
    description CHARACTER VARYING(30) NOT NULL,

    manufacturername CHARACTER VARYING(100) NOT NULL,
    agentname CHARACTER VARYING(60) NOT NULL,
    agentphnum CHARACTER VARYING(50) NOT NULL,
    country CHARACTER VARYING(100)
);

CREATE TABLE technologybook
(
    id SERIAL PRIMARY KEY,
    createdat timestamp default now() NOT NULL,
    updatedat timestamp default now() NOT NULL,
    description CHARACTER VARYING(30) NOT NULL,

    type CHARACTER VARYING(100) NOT NULL,
    method extemporalmethod NOT NULL,
    timeready CHARACTER VARYING(30) NOT NULL
);

CREATE TABLE component
(
    id SERIAL PRIMARY KEY,
    createdat timestamp default now() NOT NULL,
    updatedat timestamp default now() NOT NULL,
    description CHARACTER VARYING(30) NOT NULL,

    componentname CHARACTER VARYING(100) NOT NULL,
    measure CHARACTER VARYING(30) NOT NULL,
    criticalNorm NUMERIC CHECK(criticalnorm > -1),
    instock  NUMERIC CHECK(instock > -1),
    price NUMERIC CHECK(price > -1)
);

CREATE TABLE requestcomponent
(
    id SERIAL PRIMARY KEY,
    createdat timestamp default now() NOT NULL,
    updatedat timestamp default now() NOT NULL,
    description CHARACTER VARYING(30) NOT NULL,

    componentid INTEGER REFERENCES component(id) ON DELETE CASCADE ON UPDATE CASCADE,
    requestquantity NUMERIC CHECK(requestquantity > 0) NOT NULL,
    status status NOT NULL
);

CREATE TABLE drug
(
    id SERIAL PRIMARY KEY,
    createdAt timestamp default now() NOT NULL,
    updatedAt timestamp default now() NOT NULL,
    description CHARACTER VARYING(30) NOT NULL,

    drugname CHARACTER VARYING(100) NOT NULL,
    volume NUMERIC,
    use use NOT NULL,
    prescript TEXT,
    releaseform releaseForm NOT NULL,
    expirationdate CHARACTER VARYING(30),
    price NUMERIC CHECK(price > -1),
    technologyid INTEGER REFERENCES technologybook(id) ON DELETE CASCADE ON UPDATE CASCADE,
    componentid INTEGER REFERENCES component(id) ON DELETE CASCADE ON UPDATE CASCADE,
    manufacturerid INTEGER REFERENCES manufacturer(id) ON DELETE CASCADE ON UPDATE CASCADE,
    officinalexpirationdate timestamp,
    officinalinstock INTEGER CHECK(officinalinstock > -1)
);

CREATE TABLE orderr
(
    id SERIAL PRIMARY KEY,
    createdat timestamp default now(),
    updatedat timestamp default now(),
    description CHARACTER VARYING(30) NOT NULL,

    clientid INTEGER REFERENCES client(id) ON DELETE CASCADE ON UPDATE CASCADE,
    docname CHARACTER VARYING(100) NOT NULL,
    diagnos CHARACTER VARYING(100) NOT NULL,
    drugid INTEGER REFERENCES drug(id) ON DELETE CASCADE ON UPDATE CASCADE,
    drugquantity INTEGER CHECK(drugquantity > 0) NOT NULL,
    orderstatus orderstatus NOT NULL,
    price NUMERIC CHECK(price > -1) NOT NULL,
    ordergo timestamp
);

CREATE TABLE roles(
    role_id SERIAL PRIMARY KEY NOT NULL,
    rolename CHARACTER VARYING(20) NOT NULL
);


CREATE TABLE keys
(
    id SERIAL PRIMARY KEY,

    username CHARACTER VARYING(50) NOT NULL UNIQUE,
    password CHARACTER VARYING(200) NOT NULL UNIQUE,
    fk_role_id INTEGER REFERENCES roles(role_id) ON DELETE CASCADE ON UPDATE CASCADE
);