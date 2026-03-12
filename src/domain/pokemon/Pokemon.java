package domain.pokemon;

public abstract class Pokemon {
    private String nick;
    private Integer cp;
    private Integer hp;

    public Pokemon(String nick, Integer cp, Integer hp) {
        setNick(nick);
        setCp(cp);
        setHp(hp);
    }

    // Getters
    public String getNick() {
        return nick;
    }

    public Integer getCp() {
        return cp;
    }

    public Integer getHp() {
        return hp;
    }

    // Setters
    public void setNick(String nick) {
        if(nick == null || nick.trim().isEmpty() || nick.length() < 3) {
            throw new IllegalArgumentException("O nome não pode ser nulo e deve conter mais que três caracteres");
        }

        this.nick = nick;
    }

    public void setCp(Integer cp) {
        if(cp == null || cp < 0) {
            throw new IllegalArgumentException("O CP deve ser preenchido e maior que 0");
        }

        this.cp = cp;
    }

    public void setHp(Integer hp) {
        if(hp == null || hp < 0) {
            throw new IllegalArgumentException("O HP deve ser preenchido e maior que 0");
        }

        this.hp = hp;
    }

    @Override
    public String toString() {
        return String.format("%s(nick=%s, cp=%d, hp=%d)",
        getClass().getSimpleName(), nick, cp, hp);
    }
}

