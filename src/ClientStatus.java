import lombok.Getter;

@Getter
public enum ClientStatus {
    FIZLICO("Физ. лицо"),
    IP("Индивидуальный предприниматель"),
    URLIZO("Юр. лицо");

    private final String localisation;

ClientStatus(String localisation) {
    this.localisation = localisation;
}
}
