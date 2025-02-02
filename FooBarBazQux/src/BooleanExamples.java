public class BooleanExamples
{
    public boolean isAcceptableScore(int score, int minRequired, int maxPossible) {
        // Original expression
        return (score >= minRequired && score <= maxPossible) ||
                (score >= minRequired && score > 0) ||
                (score >= minRequired && score <= maxPossible && score > 0);

        // Can be reduced to:
        // return score >= minRequired && score <= maxPossible;
    }

    public boolean isValidDataTransfer(int packetSize, int bandwidth, boolean isEncrypted, boolean isCompressed) {
        // Original expression
        return (packetSize <= bandwidth && isEncrypted) ||
                !((!isEncrypted || !isCompressed) && packetSize > bandwidth) ||
                (isEncrypted && isCompressed && packetSize <= bandwidth) ||
                (!(packetSize > bandwidth) && (isEncrypted || isCompressed));

        // First, apply De Morgan's to !((!isEncrypted || !isCompressed) && packetSize > bandwidth)
        // = (isEncrypted && isCompressed) || !(packetSize > bandwidth)
        // = (isEncrypted && isCompressed) || (packetSize <= bandwidth)

        // Then combine similar terms and simplify to:
        // return packetSize <= bandwidth || (isEncrypted && isCompressed);
    }

    public boolean canProcessRequest(int serverLoad, int maxLoad, boolean hasPermission, boolean isAdmin) {
        // Original expression
        return !(serverLoad >= maxLoad && !hasPermission && !isAdmin) ||
                (serverLoad < maxLoad && (hasPermission || isAdmin)) ||
                !(!hasPermission && !isAdmin && serverLoad >= maxLoad) ||
                (!(serverLoad >= maxLoad) && (hasPermission || isAdmin));

        // First apply De Morgan's to !(serverLoad >= maxLoad && !hasPermission && !isAdmin)
        // = serverLoad < maxLoad || hasPermission || isAdmin
        // Also to !(!hasPermission && !isAdmin)
        // = hasPermission || isAdmin

        // Then combine and reduce to:
        // return serverLoad < maxLoad || hasPermission || isAdmin;
    }

    public boolean isQualifiedCandidate(int experience, int certifications, boolean hasReferences, boolean hasPortfolio) {
        // Original expression
        return (experience >= 5 && !(certifications < 2 || !hasReferences)) ||
                (!(!hasReferences && !hasPortfolio) && experience >= 5) ||
                !(experience < 5 || (!hasReferences && certifications < 2)) ||
                (experience >= 5 && certifications >= 2 && (hasReferences || hasPortfolio));

        // First apply De Morgan's to !(certifications < 2 || !hasReferences)
        // = certifications >= 2 && hasReferences
        // And to !(!hasReferences && !hasPortfolio)
        // = hasReferences || hasPortfolio
        // And to !(experience < 5 || (!hasReferences && certifications < 2))
        // = experience >= 5 && (hasReferences || certifications >= 2)

        // After combining terms and further reduction:
        // return experience >= 5 && (hasReferences || certifications >= 2);
    }


}
